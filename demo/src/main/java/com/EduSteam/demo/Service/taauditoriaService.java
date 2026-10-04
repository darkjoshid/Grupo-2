package com.EduSteam.demo.Service;

import com.EduSteam.demo.Entity.taauditoriaEntity;

import java.util.List;

public interface taauditoriaService {
    taauditoriaEntity GuardarAuditoria(taauditoriaEntity auditoria);
    taauditoriaEntity registrarAuditoria(Long idUsuario);
    taauditoriaEntity registrarEdicion(Long idUsuario);
    taauditoriaEntity registrarEliminacion(Long idUsuario);
    List<taauditoriaEntity> listarAuditoria();
    void eliminarAuditoria(Integer idauditoria);

}
