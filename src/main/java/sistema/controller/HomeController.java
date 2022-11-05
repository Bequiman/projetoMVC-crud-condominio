package sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sistema.model.Apartamento;
import sistema.model.Proprietario;
import sistema.model.Tipo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    JdbcTemplate db;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/proprietarios")
    public String proprietario(Model model) {
        List<Proprietario> listaDeProprietarios = db.query(
                "select id_proprietario,nome,telefone from proprietario",
                (res, rowNum) -> {
                    Proprietario p = new Proprietario(
                            res.getInt("id_proprietario"),
                            res.getString("nome"),
                            res.getString("telefone"),
                            null);
                    return p;
                });
        model.addAttribute("contatos", listaDeProprietarios);
        return "proprietario";
    }

    @GetMapping("/apartamento")
    public String apartamento(Model model) {
        List<Apartamento> listaDeApartamentos = db.query(
                "select id_apartamento,nro_da_porta,qtde_quartos,tipo, id_proprietario from apartamento",
                (res, rowNum) -> {
                    Apartamento a = new Apartamento(
                            res.getInt("id_apartamento"),
                            res.getInt("nro_da_porta"),
                            res.getInt("qtde_quartos"),
                            res.getString("tipo"));
                    return a;
                });
        model.addAttribute("contatos", listaDeApartamentos);
        return "apartamento";
    }

    @GetMapping("novo")
    public String exibeForm(Model model) {
        model.addAttribute("prop", new Proprietario());
        return "formulario";
    }

    @PostMapping("novo")
    public String cadastroProprietario(Proprietario proprietario) {
        System.out.println(proprietario.getNome());
        db.update(
                "insert into proprietario (nome, telefone) values (?,?)",
                proprietario.getNome(),
                proprietario.getTelefone());
        return "home";
    }

   

}
