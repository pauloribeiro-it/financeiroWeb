/*
 * C�digo-fonte do livro "Programa��o Java para a Web"
 * Autores: D�cio Heinzelmann Luckow <decioluckow@gmail.com>
 *          Alexandre Altair de Melo <alexandremelo.br@gmail.com>
 *
 * ISBN: 978-85-7522-238-6
 * http://www.javaparaweb.com.br
 * http://www.novatec.com.br/livros/javaparaweb
 * Editora Novatec, 2010 - todos os direitos reservados
 *
 * LICEN�A: Este arquivo-fonte est� sujeito a Atribui��o 2.5 Brasil, da licen�a Creative Commons,
 * que encontra-se dispon�vel no seguinte endere�o URI: http://creativecommons.org/licenses/by/2.5/br/
 * Se voc� n�o recebeu uma c�pia desta licen�a, e n�o conseguiu obt�-la pela internet, por favor,
 * envie uma notifica��o aos seus autores para que eles possam envi�-la para voc� imediatamente.
 *
 *
 * Source-code of "Programa��o Java para a Web" book
 * Authors: D�cio Heinzelmann Luckow <decioluckow@gmail.com>
 *          Alexandre Altair de Melo <alexandremelo.br@gmail.com>
 *
 * ISBN: 978-85-7522-238-6
 * http://www.javaparaweb.com.br
 * http://www.novatec.com.br/livros/javaparaweb
 * Editora Novatec, 2010 - all rights reserved
 *
 * LICENSE: This source file is subject to Attribution version 2.5 Brazil of the Creative Commons
 * license that is available through the following URI:  http://creativecommons.org/licenses/by/2.5/br/
 * If you did not receive a copy of this license and are unable to obtain it through the web, please
 * send a note to the authors so they can mail you a copy immediately.
 *
 */
package financeiro.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import financeiro.categoria.Categoria;
import financeiro.categoria.CategoriaRN;
import financeiro.web.util.ContextoUtil;

@ManagedBean(name = "categoriaBean")
@RequestScoped
public class CategoriaBean {

	private TreeNode	       categoriasTree;
	private Categoria	       editada	     = new Categoria();
	private List<SelectItem>	categoriasSelect;
	private boolean	       mostraEdicao	= false;

	public void novo() {
		Categoria pai = null;
		if (this.editada.getCodigo() != null) {
			CategoriaRN categoriaRN = new CategoriaRN();
			pai = categoriaRN.carregar(this.editada.getCodigo());
		}
		this.editada = new Categoria();
		this.editada.setPai(pai);
		this.mostraEdicao = true;
	}

	public void selecionar(NodeSelectEvent event) {
		this.editada = (Categoria) event.getTreeNode().getData();

		Categoria pai = this.editada.getPai();
		if (this.editada != null && pai != null && pai.getCodigo() != null) {
			this.mostraEdicao = true;
		} else {
			this.mostraEdicao = false;
		}
	}

	public void salvar() {
		ContextoBean contextoBean = ContextoUtil.getContextoBean();

		CategoriaRN categoriaRN = new CategoriaRN();
		this.editada.setUsuario(contextoBean.getUsuarioLogado());
		categoriaRN.salvar(this.editada);

		this.editada = null;
		this.mostraEdicao = false;
		this.categoriasTree = null;
		this.categoriasSelect = null;
	}

	public void excluir() {
		CategoriaRN categoriaRN = new CategoriaRN();
		categoriaRN.excluir(this.editada);
		this.editada = null;

		this.mostraEdicao = false;
		this.categoriasTree = null;
		this.categoriasSelect = null;
	}

	public TreeNode getCategoriasTree() {
		if (this.categoriasTree == null) {
			ContextoBean contextoBean = ContextoUtil.getContextoBean();

			CategoriaRN categoriaRN = new CategoriaRN();
			List<Categoria> categorias = categoriaRN.listar(contextoBean.getUsuarioLogado());

			this.categoriasTree = new DefaultTreeNode(null, null);
			this.montaDadosTree(this.categoriasTree, categorias);
		}
		return this.categoriasTree;
	}

	private void montaDadosTree(TreeNode pai, List<Categoria> lista) {
		if (lista != null && lista.size() > 0) {
			TreeNode filho = null;
			for (Categoria categoria : lista) {
				filho = new DefaultTreeNode(categoria, pai);
				this.montaDadosTree(filho, categoria.getFilhos());
			}
		}
	}

	public List<SelectItem> getCategoriasSelect() {
		if (this.categoriasSelect == null) {
			this.categoriasSelect = new ArrayList<SelectItem>();
			ContextoBean contextoBean = ContextoUtil.getContextoBean();

			CategoriaRN categoriaRN = new CategoriaRN();
			List<Categoria> categorias = categoriaRN.listar(contextoBean.getUsuarioLogado());
			this.montaDadosSelect(this.categoriasSelect, categorias, "");
		}
		return categoriasSelect;
	}

	private void montaDadosSelect(List<SelectItem> select, List<Categoria> categorias, String prefixo) {

		SelectItem item = null;
		if (categorias != null) {
			for (Categoria categoria : categorias) {
				item = new SelectItem(categoria, prefixo + categoria.getDescricao());
				item.setEscape(false);
				select.add(item);
				this.montaDadosSelect(select, categoria.getFilhos(), prefixo + "&nbsp;&nbsp;");
			}
		}
	}

	public boolean isMostraEdicao() {
		return mostraEdicao;
	}

	public void setMostraEdicao(boolean mostraEdicao) {
		this.mostraEdicao = mostraEdicao;
	}

	public Categoria getEditada() {
		return editada;
	}

	public void setEditada(Categoria editada) {
		this.editada = editada;
	}
}
