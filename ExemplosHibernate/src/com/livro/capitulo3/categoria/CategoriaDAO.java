package com.livro.capitulo3.categoria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.livro.capitulo3.conexao.HibernateUtil;

public class CategoriaDAO {
	private Session sessao;
	private Transaction transacao;

	public void salvar(Categoria categoria) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.save(categoria);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel inserir a categoria. Erro: "
					+ e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen()) {
					this.sessao.close();
				}
			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar opera��o de inser��o. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	public void atualizar(Categoria categoria) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(categoria);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel alterar a categoria. Erro: "
					+ e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen()) {
					this.sessao.close();
				}
			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar opera��o de atualiza��o. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	public void excluir(Categoria categoria) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.delete(categoria);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel excluir a categoria. Erro: "
					+ e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen()) {
					this.sessao.close();
				}
			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar opera��o de exclus�o. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	public Categoria buscaCategoria(Integer codigo) {
		Categoria categoria = null;
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Categoria.class);
			filtro.add(Restrictions.eq("categoria", codigo));
			categoria = (Categoria) filtro.uniqueResult();
			this.transacao.commit();
		} catch (Throwable e) {
			if(this.transacao.isActive()){
				this.sessao.close();
			}
		}finally{
			try{
				if(this.sessao.isOpen())
					this.sessao.close();
			}catch(Throwable e){
				System.out.println("Erro ao fechar opera��o de listagem. Mensagem: "+e.getMessage());
			}
		}
		return categoria;
	}
	public List<Categoria> listar(){
		List<Categoria> categorias = null;
		try{
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Categoria.class);
			categorias = filtro.list();
			this.transacao.commit();
		}catch(Throwable e){
			if(this.transacao.isActive())
				this.transacao.rollback();
		}finally{
			try{
				if(this.sessao.isOpen())
					this.sessao.close();
			}catch(Throwable e){
				System.out.println("Erro ao fechar opera��o de listagem. Mensagem: "+e.getMessage());
			}
		}
		
		
		return categorias;
		
	}
}