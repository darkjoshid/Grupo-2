package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.teusuarioEntity;
import com.EduSteam.demo.Entity.ttcuentaEntity;
import com.EduSteam.demo.Repository.ttcuentaRepository;
import com.EduSteam.demo.Service.taauditoriaService;
import com.EduSteam.demo.Service.ttcuentaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ttcuentaImpl implements ttcuentaService {
    @Autowired
    private ttcuentaRepository repository;
    @Autowired
    private taauditoriaService auditoriaservice;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ttcuentaEntity> ListarCuenta() {
        List<ttcuentaEntity>listar=new ArrayList<>();
        listar=repository.findAll();
        return listar;
    }

    @Override
    public ttcuentaEntity GuardarActualizar(ttcuentaEntity ttcuenta) {
        if (ttcuenta.getUsuario() != null &&
                ttcuenta.getUsuario().getIdusuario() != null) {
            Long idusuario = ttcuenta.getUsuario().getIdusuario();
            teusuarioEntity usuario = entityManager.find(
                            teusuarioEntity.class,
                            idusuario
                    );
            ttcuenta.setUsuario(usuario);
        }
        boolean esEdicion=ttcuenta.getIdcuenta()!=null;
        ttcuentaEntity cuantaGuardada=repository.save(ttcuenta);
        if(cuantaGuardada.getUsuario()!=null){
            Long idusuario=cuantaGuardada.getUsuario().getIdusuario();
            if(esEdicion){
                auditoriaservice.registrarEdicion(idusuario);
            }
            else{
                auditoriaservice.registrarAuditoria(idusuario);
            }
        }
        return cuantaGuardada;
    }

    @Override
    public void EliminarCuenta(Integer idcuenta) {
        ttcuentaEntity cuenta=repository.findById(idcuenta).orElse(null);
        if(cuenta!=null){
            Long idusuario=cuenta.getUsuario().getIdusuario();
            auditoriaservice.registrarEliminacion(idusuario);
            repository.deleteById(idcuenta);
        }
    }
}
