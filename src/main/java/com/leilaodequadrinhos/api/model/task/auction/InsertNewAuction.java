package com.leilaodequadrinhos.api.model.task.auction;

import com.leilaodequadrinhos.api.model.dao.*;
import com.leilaodequadrinhos.api.model.dao.impl.jdbc.*;
import com.leilaodequadrinhos.api.model.entities.EstadoLeilao;
import com.leilaodequadrinhos.api.model.entities.Leilao;
import com.leilaodequadrinhos.api.model.entities.User;
import com.leilaodequadrinhos.api.model.task.Task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertNewAuction implements Task {
    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        LeilaoDao leilaoDao = new LeilaoDAO();
        Leilao leilao = new Leilao();

        EstadoLeilaoDao estadoLeilaoDao = new EstadoLeilaoDAO();
        ProdutoDao produtoDao = new ProdutoDAO();
        UserDao userDao = new UserDAO();

        Long idPersonagem = Long.parseLong(request.getParameter("characterID"));
        Long idProduto = Long.parseLong(request.getParameter("productID"));
        Long idEstadoLeilao = Long.parseLong(request.getParameter("auctionStatusID"));

        leilao.setDuracao(Integer.parseInt(request.getParameter("duration")));
        String format = "dd/MM/yyyy";
        leilao.setDataInicio(new SimpleDateFormat(format).parse(request.getParameter("StartDate")));
        leilao.setValorInicial(Float.parseFloat(request.getParameter("BasePrice")));
        leilao.setValorAtual(leilao.getValorInicial());
        leilao.setLancePadrao(Float.parseFloat(request.getParameter("BaseBid")));
        leilao.setEstado(estadoLeilaoDao.findById(idEstadoLeilao));
        leilao.setProduto(((ProdutoDAO) produtoDao).findById(idProduto));
        leilao.setUser(((UserDAO) userDao).findById(idPersonagem));

        leilaoDao.insert(leilao);

        return "Leilao Cadastrado";
    }
}
