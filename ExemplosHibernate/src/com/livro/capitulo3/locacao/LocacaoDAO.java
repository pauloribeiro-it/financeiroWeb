package com.livro.capitulo3.locacao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.livro.capitulo3.conexao.HibernateUtil;

public class LocacaoDAO {
	private Session sessao;
	private Transaction transacao;

	public void salvar(Locacao locacao) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.save(locacao);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir o filme. Erro: "
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

	public void atualizar(Locacao locacao) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(locacao);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível alterar o filme. Erro: "
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

	public void excluir(Locacao locacao) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.delete(locacao);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível excluir o filme. Erro: "
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

	public Locacao buscaCategoria(Integer codigo) {
		Locacao locacao = null;
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Locacao.class);
			filtro.add(Restrictions.eq("filme", codigo));
			locacao = (Locacao) filtro.uniqueResult();
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
		return locacao;
	}
	public List<Locacao> listar(){
		List<Locacao> locacoes = null;
		try{
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Locacao.class);
			locacoes = filtro.list();
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
		return locacoes;
		
	}
}