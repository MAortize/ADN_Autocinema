package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(tags = { "Controlador comando usuario"})
public class ComandoControladorUsuario {

    private final ManejadorCrearUsuario manejadorCrearUsuario;
	private final ManejadorEliminarUsuario manejadorEliminarUsuario;
	private final ManejadorActualizarUsuario manejadorActualizarUsuario;

    @Autowired
    public ComandoControladorUsuario(ManejadorCrearUsuario manejadorCrearUsuario,
									 ManejadorEliminarUsuario manejadorEliminarUsuario,
									 ManejadorActualizarUsuario manejadorActualizarUsuario) {
        this.manejadorCrearUsuario = manejadorCrearUsuario;
		this.manejadorEliminarUsuario = manejadorEliminarUsuario;
		this.manejadorActualizarUsuario = manejadorActualizarUsuario;
    }

    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoUsuario comandoUsuario) {
        return manejadorCrearUsuario.ejecutar(comandoUsuario);
    }

    @DeleteMapping(value="/{id_usuario}")
	@ApiOperation("Eliminar Usuario")
	public void eliminar(@PathVariable(name = "id_usuario") Long id) {
		manejadorEliminarUsuario.ejecutar(id);
	}

	@PutMapping(value="/{id_usuario}")
	@ApiOperation("Actualizar Usuario")
	public void actualizar(@RequestBody ComandoUsuario comandoUsuario,@PathVariable(name = "id_usuario") Long id) {
		comandoUsuario.setId_usuario(id);
		manejadorActualizarUsuario.ejecutar(comandoUsuario);
	}
}
