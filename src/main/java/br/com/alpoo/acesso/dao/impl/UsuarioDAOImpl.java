package br.com.alpoo.acesso.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import br.com.alpoo.acesso.dao.IUsuarioDAO;
import br.com.alpoo.acesso.entity.UsuarioEntity;
import br.com.alpoo.exceptions.CustomException;
import br.com.alpoo.exceptions.NaoEncontradoException;
import br.com.alpoo.util.dao.impl.GenericDAOImpl;

@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<UsuarioEntity, Serializable> implements IUsuarioDAO {
	
}
