package com.api.cadastroDeObras.controlador;

import com.api.cadastroDeObras.dto.ObraRequestDto;
import com.api.cadastroDeObras.dto.ObraResponseDto;
import com.api.cadastroDeObras.servico.ObraServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor/{codigoAutor}/obra")
public class ObraControlador {

    @Autowired
    private ObraServico obraServico;
    
    @GetMapping
    public ResponseEntity<List<ObraResponseDto>> listarObraPorAutor(@PathVariable Long codigoAutor) {
        return ResponseEntity.ok(obraServico.listarObraPorAutor(codigoAutor));
    }
    
    @GetMapping("/{codigoObra}")
    public ResponseEntity<ObraResponseDto> listarObraPorCodigo(@PathVariable Long codigoObra) {
        return ResponseEntity.ok(obraServico.listarObraPorCodigo(codigoObra));
    }
    
    @PostMapping
    public ResponseEntity<ObraResponseDto> cadastrarObra(@RequestBody ObraRequestDto obraRequestDto, @PathVariable Long codigoAutor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(obraServico.cadastrarObra(obraRequestDto, codigoAutor));
    }
    
    @PutMapping("/{codigoObra}")
    public ResponseEntity<ObraResponseDto> atualizarObra(@RequestBody ObraRequestDto obraRequestDto, @PathVariable Long codigoAutor, @PathVariable Long codigoObra) {
        return ResponseEntity.ok(obraServico.atualizarObra(obraRequestDto, codigoAutor, codigoObra));
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{codigoObra}")
    public void deletarObra (@PathVariable Long codigoObra) {
        obraServico.deletarObra(codigoObra);
    }
}
