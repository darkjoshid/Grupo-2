package com.EduSteam.demo.Service.Impl;

import com.EduSteam.demo.Entity.taauditoriaEntity;
import com.EduSteam.demo.Repository.taauditoriaRepository;
import com.EduSteam.demo.Service.taauditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class taauditoriaImpl implements taauditoriaService {
    @Autowired
    private taauditoriaRepository repository;

    @Override
    public taauditoriaEntity GuardarAuditoria(taauditoriaEntity auditoria) {
        return repository.save(auditoria);
    }

    @Override
    public taauditoriaEntity registrarAuditoria(Long idUsuario) {
        taauditoriaEntity auditoria = new taauditoriaEntity();

        auditoria.setIdusuarioregistro(idUsuario);
        auditoria.setFecharegistro(LocalDateTime.now());
        auditoria.setEstado(true);

        return repository.save(auditoria);
    }

    @Override
    public taauditoriaEntity registrarEdicion(Long idUsuario) {
        taauditoriaEntity auditoria = new taauditoriaEntity();

        auditoria.setIdusuarioeditar(idUsuario);
        auditoria.setFechaeditar(LocalDateTime.now());
        auditoria.setEstado(true);

        return repository.save(auditoria);
    }

    @Override
    public taauditoriaEntity registrarEliminacion(Long idUsuario) {
        taauditoriaEntity auditoria = new taauditoriaEntity();

        auditoria.setIdusuarioeliminar(idUsuario);
        auditoria.setFechaeliminar(LocalDateTime.now());
        auditoria.setEstado(true);

        return repository.save(auditoria);
    }

    @Override
    public List<taauditoriaEntity> listarAuditoria() {
        return repository.findAll();
    }

    @Override
    public void eliminarAuditoria(Integer idauditoria) {
        repository.deleteById(idauditoria);
    }
}
