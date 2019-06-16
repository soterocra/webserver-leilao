package com.leilaodequadrinhos.api.model.task.product;

import com.leilaodequadrinhos.api.model.dao.DaoFactory;
import com.leilaodequadrinhos.api.model.dao.ProdutoDao;
import com.leilaodequadrinhos.api.model.entities.Produto;
import com.leilaodequadrinhos.api.model.task.Task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadProductByID implements Task {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ProdutoDao produtoDao = DaoFactory.createProdutoDao();
        Integer id = Integer.parseInt(request.getParameter("productID"));
        Produto produto = produtoDao.findById(id);
        request.setAttribute("produto", produto);
        return "produto carregado";
    }
}