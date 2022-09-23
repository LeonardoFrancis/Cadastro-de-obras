package com.api.cadastroDeObras.servico;

import com.api.cadastroDeObras.dto.ObraRequestDto;
import com.api.cadastroDeObras.dto.ObraResponseDto;
import com.api.cadastroDeObras.entidades.Autor;
import com.api.cadastroDeObras.entidades.Obra;
import com.api.cadastroDeObras.repositorio.ObraRepositorio;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ObraServico {
    
    @Autowired
    private ObraRepositorio obraRepositorio;
    @Autowired
    private AutorServico autorServico;
    @Autowired
    private ModelMapper modelmapper;
    
    public List<ObraResponseDto> listarObraPorAutor(Long codigoAutor) {
        autorServico.validarExistenciaAutor(codigoAutor);
        return obraRepositorio.findByAutorCodigoAutor(codigoAutor)
                .stream().map(this::converterParaObraResponseDto)
                .collect(Collectors.toList());
    }
    
    public ObraResponseDto listarObraPorCodigo(Long codigoObra) {
        Obra obra = validarExistenciaObra(codigoObra);
        return converterParaObraResponseDto(obra);
    }
    
    public ObraResponseDto cadastrarObra (ObraRequestDto obraRequestDto, Long codigoAutor) {
        Autor autor = autorServico.validarExistenciaAutor(codigoAutor);
        obraRequestDto.setAutor(autor);
        Obra obra = converterObraRequestParaEntidade(obraRequestDto);
        return converterParaObraResponseDto(obraRepositorio.save(obra));
    }
    
    public ObraResponseDto atualizarObra(ObraRequestDto obraRequestDto, Long codigoAutor, Long codigoObra) {
        autorServico.validarExistenciaAutor(codigoAutor);
        Obra obraValidada = validarExistenciaObra(codigoObra);
        BeanUtils.copyProperties(obraRequestDto, obraValidada, "codigoObra");
        return converterParaObraResponseDto(obraRepositorio.save(obraValidada));
    }
    
    public void deletarObra(Long codigoObra) {
        validarExistenciaObra(codigoObra);
        obraRepositorio.deleteById(codigoObra);
    }
    
    public ObraResponseDto converterParaObraResponseDto(Obra obra) {
        return modelmapper.map(obra, ObraResponseDto.class);
    }
    
    public Obra converterObraRequestParaEntidade(ObraRequestDto obraRequestDto) {
        return modelmapper.map(obraRequestDto, Obra.class);
    } 
    
    public Obra validarExistenciaObra(Long codigoObra) {
        Optional<Obra> obra = obraRepositorio.findById(codigoObra);
        if (obra.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return obra.get();
    }
}
