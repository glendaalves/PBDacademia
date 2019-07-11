/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pbd.controles;

import br.com.pbd.Fachada.Fachada;
import br.com.pbd.modelos.Caixa;
import br.com.pbd.modelos.ItemVenda;
import br.com.pbd.modelos.Produto;
import br.com.pbd.modelos.Render;
import br.com.pbd.modelos.Venda;
import br.com.pbd.view.AdicionarProduto;
import br.com.pbd.view.Mensagens;
import br.com.pbd.view.Pagamento;
import br.com.pbd.view.Principal;
import br.com.pbd.view.Quantidade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleVendas extends MouseAdapter implements ActionListener, KeyListener {
    
    private final Principal principal;
    private final Fachada fachada;
    private AdicionarProduto adicionarProduto;
    private List<Produto> produtos;
    private int escolha = 0;
    private final int editar = 1, adicionar = 2, excluir = 3;
    private double valortotal = 0, desconto = 0, subtotal = 0;
    private Produto produto;
    private final Quantidade quantidade;
    private List<ItemVenda> itensVenda;
    private Venda venda;
    private final Pagamento pagamento;
    private final Mensagens mensagens;
    private int indiceTemp;
    private ItemVenda iv;
    
    public ControleVendas(Principal principal, Fachada fachada) {
        this.principal = principal;
        this.fachada = fachada;
        itensVenda = new ArrayList<ItemVenda>();
        adicionarProduto = new AdicionarProduto(principal, true);
        pagamento = new Pagamento(principal, true);
        quantidade = new Quantidade(principal, true);
        principal.getBotaoVenda().addActionListener(this);
        principal.getVenda().getBotaoAdicionarprodutos().addActionListener(this);
        adicionarProduto.getPesquise().addKeyListener(this);
        quantidade.getBotaook().addActionListener(this);
        adicionarProduto.getTabelaproduto().addMouseListener(this);
        principal.getVenda().getBotaofinalizarvenda().addActionListener(this);
        principal.getVenda().getValordesconto().addKeyListener(this);
        pagamento.getBotaocomfirmar().addActionListener(this);
        principal.getVenda().getBotaoFechar().addActionListener(this);
        principal.getVenda().getTabelaprodutosvenda().addMouseListener(this);
        principal.getVenda().getBotaocancelarvenda().addActionListener(this);
        mensagens = new Mensagens(principal, true);
        
        pagamento.getDinheri().addKeyListener(new KeyAdapter() {
            
            public void keyReleased(KeyEvent e) {
                Double valort = 0.000, dinheiro = null, trocoCliente;
                
                try {
                    dinheiro = Double.parseDouble(pagamento.getDinheri().getText());
                    valort = Double.parseDouble(pagamento.getValorTotal().getText());
                    trocoCliente = dinheiro - valort;
                    pagamento.getTroco().setText(trocoCliente + "");
                    
                } catch (NumberFormatException erro) {
                    mensagens.mensagens("valor Invalido !", "advertencia");
                    pagamento.getTroco().setText("0.00");
                } catch (java.lang.NullPointerException i) {
                    mensagens.mensagens("Valor Invaldo !", "advertencia");
                    pagamento.getTroco().setText("0.00");
                }
                
            }
        });
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == adicionarProduto.getTabelaproduto()) {
            int ro = retornaIndice(adicionarProduto.getTabelaproduto(), e);
            produto = produtos.get(ro);
            if (escolha == adicionar) {
                quantidade.setVisible(true);
                quantidade.getTxtquantidade().setText("");
            }
        }
        if (e.getSource() == principal.getVenda().getTabelaprodutosvenda()) {
            indiceTemp = retornaIndice(principal.getVenda().getTabelaprodutosvenda(), e);
            produto = produtos.get(indiceTemp);
            if (escolha == excluir) {
                removerItem(produto);
                
            }
            if (escolha == editar) {
                quantidade.setVisible(true);
                quantidade.getTxtquantidade().setText("");
            }
        }
//        if (e.getSource() == principal.getVenda().getTabelaprodutosvenda()) {
//            indiceTemp = retornaIndice(principal.getVenda().getTabelaprodutosvenda(), e);
//           
//        }

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == principal.getVenda().getBotaocancelarvenda()) {
            mensagens.mensagens("Venda Cancelada", "info");
            zeraValores();
        }
        if (e.getSource() == principal.getBotaoVenda()) {
            if (ControleLogin.getFuncionario() != null) {
                principal.getVenda().setVisible(true);
                venda = new Venda();
                principal.Desativar();
                preencherVazio(principal.getVenda().getTabelaprodutosvenda());
            } else {
                mensagens.mensagens("Voce Não tem Acesso !", "advertencia");
            }
        }
        if (e.getSource() == principal.getVenda().getBotaoFechar()) {
            preencherVazio(principal.getVenda().getTabelaprodutosvenda());
            principal.Ativar();
        }
        if (e.getSource() == principal.getVenda().getBotaofinalizarvenda()) {
            if (!itensVenda.isEmpty()) {
                if (desconto == 0) {
                    valortotal = subtotal;
                }
                pagamento.getValorTotal().setText(valortotal + "");
                pagamento.setVisible(true);
            } else {
                mensagens.mensagens("Venda vazia", "info");
            }
            
        }
        if (e.getSource() == pagamento.getBotaocomfirmar()) {
            salvarVenda();
            saidaProduto(itensVenda);
            zeraValores();
            
        }
        
        if (e.getSource() == quantidade.getBotaook()) {
            
            if (escolha == adicionar) {
                adicionarProduto();
                preencherTabelaProdutoAdicionados(itensVenda);
            } else if (escolha == editar) {
                editarQuantidade();
            }
            
        }
        if (e.getSource() == principal.getVenda().getBotaoAdicionarprodutos()) {
            quantidade.getTxtquantidade().setText("");
            produtos = fachada.BuscarQuantidade();
            preencherTabelaProduto(produtos);
            
        }
        
    }
    
    private void salvarVenda() {
        String forma = "";
        if (pagamento.getDinheiro().isSelected()) {
            forma = "Dinheiro";
        } else if (pagamento.getCartao().isSelected()) {
            forma = "Cartão";
        } else {
            forma = "Cheque";
        }
        
        try {
            venda.setForma_pagamento(forma);
            venda.setItemVendas(itensVenda);
            venda.setFuncionario(ControleLogin.getFuncionario());
            venda.setCaixa(buscarCaixar());
            venda.setDesconto(desconto);
            venda.setSubtotal(subtotal);
            venda.setTotal(valortotal);
            fachada.salvar(venda);
            pagamento.setVisible(false);
            
        } catch (java.lang.IllegalStateException n) {
            mensagens.mensagens("voce precisa preencher todos os campos!", "advertencia");
        } catch (javax.persistence.RollbackException roll) {
            mensagens.mensagens("Erro !!!", "erro");
        }
        
    }
    
    public Caixa buscarCaixar() {
        Caixa caixa = null;
        try {
            caixa = fachada.buscaUltimoRegistroC();
            return caixa;
        } catch (NoResultException n) {
            mensagens.mensagens("Caixa Não Encontrado", "advertencia");
        }
        return null;
    }
    
    private void adicionarProduto() {
        if (itensVenda == null) {
            itensVenda = new ArrayList<ItemVenda>();
        }
        iv = new ItemVenda();
        int numero = 0;
        try {
            numero = Integer.parseInt(quantidade.getTxtquantidade().getText());
            if (produto.getEstoque_atual() > numero && numero > 0) {
                boolean existe = false;
                if (!itensVenda.isEmpty()) {
                    for (ItemVenda i : itensVenda) {
                        if (i.getProduto().equals(produto)) {
                            existe = true;
                            int q = numero + i.getQuantidade();
                            i.setQuantidade(q);
                            i.setVenda(venda);
                        }
                    }
                    if (!existe) {
                        iv.setProduto(produto);
                        iv.setQuantidade(numero);
                        iv.setVenda(venda);
                        itensVenda.add(iv);
                        
                    }
                    existe = false;
                } else {
                    iv.setProduto(produto);
                    iv.setQuantidade(numero);
                    iv.setVenda(venda);
                    itensVenda.add(iv);
                }
                principal.getVenda().getValortotal().setText(subtotal + "");
                principal.getVenda().getValorsubtotal().setText(subtotal + "");
                adicionarProduto.setVisible(false);
                quantidade.setVisible(false);
            } else {
                mensagens.mensagens("Quantidade Invalida", "advertencia");
            }
            
        } catch (NumberFormatException erro) {
            mensagens.mensagens("Numero Invalido", "advertencia");
        }
        
    }
    
    public void zeraValores() {
        subtotal = 0;
        valortotal = 0;
        desconto = 0;
        principal.getVenda().getValordesconto().setText(desconto + "");
        itensVenda = new ArrayList<ItemVenda>();
        venda = new Venda();
        iv = new ItemVenda();
        preencherTabelaProdutoAdicionados(itensVenda);
        
    }
    
    public void preencherTabelaProduto(List<Produto> lista) {
        adicionarProduto.getTabelaproduto().setDefaultRenderer(Object.class,
                new Render());
        
        try {
            String[] colunas = new String[]{"Nome", "Tamanho/Peso", "Valor", "Estoque Atual", "Adicionar"};
            Object[][] dados = new Object[lista.size()][5];
            for (int i = 0; i < lista.size(); i++) {
                
                Produto p = lista.get(i);
                
                dados[i][0] = p.getDescricao();
                dados[i][1] = p.getTamanho_peso();
                dados[i][2] = p.getValor_venda();
                dados[i][3] = p.getEstoque_atual();
                dados[i][4] = principal.getVenda().getBtnad();
                
            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            adicionarProduto.getTabelaproduto().setModel(dataModel);
            adicionarProduto.setVisible(true);
            
        } catch (Exception ex) {
            
        }
        
    }
    
    public void preencherTabelaProdutoAdicionados(List<ItemVenda> lista) {
        principal.getVenda().getTabelaprodutosvenda().setDefaultRenderer(Object.class,
                new Render());
        subtotal = 0.00;
        try {
            String[] colunas = new String[]{"Nome", "Tamanho/Peso", "Valor", "Quantidade", "Editar", "Excluir"};
            Object[][] dados = new Object[lista.size()][6];
            for (int i = 0; i < lista.size(); i++) {
                
                ItemVenda p = lista.get(i);
                
                dados[i][0] = p.getProduto().getDescricao();
                dados[i][1] = p.getProduto().getTamanho_peso();
                dados[i][2] = p.getProduto().getValor_venda();
                dados[i][3] = p.getQuantidade();
                dados[i][4] = principal.getVenda().getBtnEd();
                dados[i][5] = principal.getVenda().getBtnEx();
                subtotal += p.getQuantidade() * p.getProduto().getValor_venda();
            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            principal.getVenda().getTabelaprodutosvenda().setModel(dataModel);
            principal.getVenda().getValorsubtotal().setText(subtotal + "");
            principal.getVenda().getValortotal().setText(subtotal + "");
        } catch (Exception ex) {
            
        }
        
    }
    
    private int retornaIndice(JTable tabela, MouseEvent e) {
        int ro = 0;
        int column = tabela.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / tabela.getRowHeight();
        
        if (row < tabela.getRowCount() && row >= 0 && column < tabela.getColumnCount() && column >= 0) {
            Object value = tabela.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                ro = tabela.getSelectedRow();
                if (boton.getName().equals("Excluir")) {
                    escolha = excluir;
                    
                }
                if (boton.getName().equals("Adicionar")) {
                    escolha = adicionar;
                    
                }
                if (boton.getName().equals("Editar")) {
                    escolha = editar;
                    
                }
                
            }
        }
        return ro;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getSource() == adicionarProduto.getPesquise()) {
            produtos = fachada.BuscaP(adicionarProduto.getPesquise().getText());
            preencherTabelaProduto(produtos);
        }
      
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
          if (e.getSource() == principal.getVenda().getValordesconto()) {
            
            double valor = 0.0;
            
            try {
                valor = Double.parseDouble(principal.getVenda().getValordesconto().getText());
                desconto = valor;
                valortotal = subtotal - desconto;
                principal.getVenda().getValortotal().setText(valortotal + "");
            } catch (NumberFormatException erro) {
                desconto = 0.00;
            }
            
        }
    }
    
    public void saidaProduto(List<ItemVenda> itemVendas) {
        itemVendas.forEach((itensVenda) -> {
            int quantidade = itensVenda.getQuantidade();
            int quantidade_estoque = itensVenda.getProduto().getEstoque_atual();
            Produto produto = itensVenda.getProduto();
            produto.setEstoque_atual(quantidade_estoque - quantidade);
            try {
                fachada.salvar(produto);
            } catch (java.lang.IllegalStateException n) {
                mensagens.mensagens("voce precisa preencher todos os campos!", "advertencia");
            } catch (javax.persistence.RollbackException roll) {
                mensagens.mensagens("Erro !!!", "erro");
            }
            
        });
        
    }
    
    public void preencherVazio(JTable tabela) {
        
        String[] colunas = new String[]{"Nome", "Tamanho/Peso", "Valor", "Quantidade", "Editar", "Excluir"};
        Object[][] dados = new Object[0][6];
        DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela.setModel(dataModel);
    }
    
    public void removerItem(Produto produto) {
        for (int i = 0; i < itensVenda.size(); i++) {
            
            if (itensVenda.get(i).getProduto() == produto) {
                itensVenda.remove(i);
            }
        }
        preencherTabelaProdutoAdicionados(itensVenda);
    }
    
    public void editarQuantidade() {
        int numero = 0;
        
        try {
            
            numero = Integer.parseInt(quantidade.getTxtquantidade().getText());
            itensVenda.get(indiceTemp).setQuantidade(numero);
            quantidade.setVisible(false);
            preencherTabelaProdutoAdicionados(itensVenda);
        } catch (NumberFormatException erro) {
            
            mensagens.mensagens("Numero Invalido", "advertencia");
        }
        
    }
}
