package com.api.cadastroDeObras.servico;

import com.api.cadastroDeObras.configuracao.RegraNegocioException;
import com.api.cadastroDeObras.dto.ObraRequestDto;
import com.api.cadastroDeObras.dto.ObraResponseDto;
import com.api.cadastroDeObras.dto.ObraResponseDto2;
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
    
    public ObraResponseDto2 listarObraPorCodigo(Long codigoObra, Long codigoAutor) {
        autorServico.validarExistenciaAutor(codigoAutor);
        Obra obra = validarExistenciaObra(codigoObra);
        return converterParaObraResponseDto2(obra);
    }
    
    public ObraResponseDto cadastrarObra (ObraRequestDto obraRequestDto, Long codigoAutor) {
        Autor autor = autorServico.validarExistenciaAutor(codigoAutor);
        validarDatasObra(obraRequestDto);
        obraRequestDto.setAutor(autor);
        Obra obra = converterObraRequestParaEntidade(obraRequestDto);
        return converterParaObraResponseDto(obraRepositorio.save(obra));
    }
    
    public ObraResponseDto atualizarObra(ObraRequestDto obraRequestDto, Long codigoAutor, Long codigoObra) {
        autorServico.validarExistenciaAutor(codigoAutor);
        Obra obraValidada = validarExistenciaObra(codigoObra);
        validarDatasObra(obraRequestDto);
        BeanUtils.copyProperties(obraRequestDto, obraValidada, "codigoObra");
        return converterParaObraResponseDto(obraRepositorio.save(obraValidada));
    }
    
    public void deletarObra(Long codigoObra, Long codigoAutor) {
        autorServico.validarExistenciaAutor(codigoAutor);
        obraRepositorio.deleteById(codigoObra);
    }
    
    public ObraResponseDto converterParaObraResponseDto(Obra obra) {
        return modelmapper.map(obra, ObraResponseDto.class);
    }
    
    public ObraResponseDto2 converterParaObraResponseDto2(Obra obra) {
        return modelmapper.map(obra, ObraResponseDto2.class);
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
    
    public void validarDatasObra (ObraRequestDto obraRequestDto) {
        if ((obraRequestDto.getDataExposicao() == null) && (obraRequestDto.getDataPublicacao() == null)) {
            throw new RegraNegocioException("Data da exposição e data da publicação estão vazias. Preencha pelo menos uma das opções.");
        }
    }
}
