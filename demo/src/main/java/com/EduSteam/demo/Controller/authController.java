package com.EduSteam.demo.Controller;

import com.EduSteam.demo.Dto.loginDto;
import com.EduSteam.demo.Dto.teusuarioDto;
import com.EduSteam.demo.Entity.teusuarioEntity;
import com.EduSteam.demo.Entity.tmrolEntity;
import com.EduSteam.demo.Repository.teusuarioRepository;
import com.EduSteam.demo.Repository.tmrolRepository;
import com.EduSteam.demo.Security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class authController {
    private final teusuarioRepository usuarioRepository;
    private final JwtUtil jwtUt;
    private final tmrolRepository tmrolRepository;

    public authController(teusuarioRepository usuarioRepository, JwtUtil jwtUt, tmrolRepository tmrolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.jwtUt = jwtUt;
        this.tmrolRepository = tmrolRepository;
    }
    @PostMapping("/login")
    public String login(@RequestBody loginDto usuarioDto){
        teusuarioEntity teusuario=usuarioRepository.findByNombreusuario(usuarioDto.getNombreusuario());
        if(teusuario!=null && new BCryptPasswordEncoder().matches(usuarioDto.getContrasenia(),teusuario.getContrasenia())){
            return jwtUt.generarToken(
                    teusuario.getNombreusuario()
            );
        }
        return "Credenciales incorrectas";
    }
    @PostMapping("/registrar")
    public String registrar (@RequestBody teusuarioDto teusuarioDto){
        teusuarioEntity teusuario=new teusuarioEntity();
        teusuario.setNombreusuario(teusuarioDto.getNombreusuario());
        teusuario.setContrasenia(new BCryptPasswordEncoder().encode(teusuarioDto.getContrasenia()));
        teusuario.setNombre(teusuarioDto.getNombre());
        teusuario.setApellido(teusuarioDto.getApellido());
        teusuario.setCorreo(teusuarioDto.getCorreo());
        teusuario.setEstadousuario(teusuarioDto.getEstadousuario());
        tmrolEntity rol = tmrolRepository.findById(teusuarioDto.getIdrolRol().getIdrol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        teusuario.setRol(rol);
        usuarioRepository.save(teusuario);
        return "Usuario creado";

    }
}
