package com.livro.capitulo3.midia;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.livro.capitulo3.conexao.HibernateUtil;

public class MidiaDAO {
	private Session sessao;
	private Transaction transacao;

	public void salvar(Midia midia) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.save(midia);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir a midia. Erro: "
					+ e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen()) {
					this.sessao.close();
				}
			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar operação de inserção. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	public void atualizar(Midia midia) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(midia);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível alterar a midia. Erro: "
					+ e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen()) {
					this.sessao.close();
				}
			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar operação de atualização. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	public void excluir(Midia midia) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.delete(midia);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível excluir a midia. Erro: "
					+ e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen()) {
					this.sessao.close();
				}
			} catch (Throwable e) {
				System.out
						.println("Erro ao fechar operação de exclusão. Mensagem: "
								+ e.getMessage());
			}
		}
	}

	public Midia buscaMidia(Integer codigo) {
		Midia filme = null;
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Midia.class);
			filtro.add(Restrictions.eq("midia", codigo));
			filme = (Midia) filtro.uniqueResult();
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
				System.out.println("Erro ao fechar operação de listagem. Mensagem: "+e.getMessage());
			}
		}
		return filme;
	}
	public List<Midia> listar(){
		List<Midia> filmes = null;
		try{
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Midia.class);
			filmes = filtro.list();
			this.transacao.commit();
		}catch(Throwable e){
			if(this.transacao.isActive())
				this.transacao.rollback();
		}finally{
			try{
				if(this.sessao.isOpen())
					this.sessao.close();
			}catch(Throwable e){
				System.out.println("Erro ao fechar operação de listagem. Mensagem: "+e.getMessage());
			}
		}
		return filmes;
		
	}
}