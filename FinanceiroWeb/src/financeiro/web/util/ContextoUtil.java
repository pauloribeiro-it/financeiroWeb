package financeiro.web.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import financeiro.web.ContextoBean;

public class ContextoUtil {
	public static ContextoBean getContextoBean(){
		FacesContext contexto = FacesContext.getCurrentInstance();
		ExternalContext external = contexto.getExternalContext();
		HttpSession session = (HttpSession) external.getSession(true);
		ContextoBean contextoBean = (ContextoBean) session.getAttribute("contextoBean");
		return contextoBean;
	}
}
