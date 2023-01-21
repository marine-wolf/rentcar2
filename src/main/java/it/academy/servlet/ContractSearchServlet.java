package it.academy.servlet;

import it.academy.dao.ContractDaoImpl;
import it.academy.model.Contract;
import it.academy.service.ContractSearchService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractSearchServlet", urlPatterns = "/rentcar/search.do")
public class ContractSearchServlet extends HttpServlet {
    private ContractSearchService contractSearchService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        contractSearchService = new ContractSearchService(new ContractDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Read input from HTTP request
        final String pname = req.getParameter("pname");
        // Handle input data with business service
        final List<Contract> contractSearchResult = contractSearchService.search(pname);
        // Save output for view/UI (JSP)
        req.setAttribute("contractSearchResult", contractSearchResult);
        getServletContext().getRequestDispatcher("/jsp/contractSearchResult.jsp")
                .forward(req, resp);
    }

    public void setContractSearchService(ContractSearchService contractSearchService) {
        this.contractSearchService = contractSearchService;
    }

}
