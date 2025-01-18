package br.com.spring_boot_swagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UsuarioController {
    @Operation(summary="Listar", description = "Método que retorna lista de nomes", tags = "Usuário")
@Api(value = "Controlador de Usuários", description = "Gerenciamento de Usuários")
public class UsuarioController {
    @ApiOperation(value = "Verifica a lista de usuários")
    @GetMapping("/lista")
    public ResponseEntity listar(){
        List<String> lista = List.of("Higo", "Souza");

        Map<String, Object> body = Map.of("nome", lista.toArray());

        return ResponseEntity.ok(body);
    }

    @Operation(summary="Mostrar", description = "Método que retorna o tamnanho da lista", tags = "Usuário")
    @ApiOperation(value = "Verifica o tamanho da lista de usuários")
    @GetMapping("/tamanho")
    public ResponseEntity tamanho(){
        List<String> lista = List.of("Higo", "Souza");

        Map<String, Object> body = Map.of("tamanho", lista.size());

        return ResponseEntity.ok(body);
    }

    @Operation(summary="Mostrar", description = "Método que retorna número maior que 5", tags = "Usuário")
    @GetMapping("/{numero}")
    public ResponseEntity<String> numero(@PathVariable Integer numero){
        return numero > 5
                ? ResponseEntity.ok("Número: " + numero)
                : ResponseEntity.ok("O número é menor que 5");
    @ApiOperation(value = "Verifica se o número é igual a 5")
    @GetMapping("/{numero}")
    public ResponseEntity<Integer> numero(@PathVariable Integer numero){
        return numero > 5
                ? ResponseEntity.ok(numero)
                : (ResponseEntity<Integer>) ResponseEntity.notFound();
    }

}
