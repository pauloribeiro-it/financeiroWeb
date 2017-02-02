package com.livro.capitulo3.endereco;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.livro.capitulo3.conexao.HibernateUtil;

public class EnderecoDAO {
	private Session sessao;
	private Transaction transacao;

	public void salvar(Endereco endereco) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.save(endereco);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel inserir o endere�o. Erro: "
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

	public void atualizar(Endereco endereco) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(endereco);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel alterar o endere�o. Erro: "
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

	public void excluir(Endereco endereco) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.delete(endereco);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel excluir o endere�o. Erro: "
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

	public Endereco buscaCategoria(Integer codigo) {
		Endereco endereco = null;
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Endereco.class);
			filtro.add(Restrictions.eq("endereco", codigo));
			endereco = (Endereco) filtro.uniqueResult();
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
		return endereco;
	}
	public List<Endereco> listar(){
		List<Endereco> enderecos = null;
		try{
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Endereco.class);
			enderecos = filtro.list();
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
		
		
		return enderecos;
		
	}
}