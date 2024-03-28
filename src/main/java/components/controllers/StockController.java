package components.controllers;

import components.dao.ProductDAO;
import components.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/stock")
public class StockController {

    private final ProductDAO productDAO;

    @Autowired
    public StockController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("stock", productDAO.index());
        return "stock/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productDAO.show(id));
        return "stock/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("product") Product product) {
        return "stock/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") @Validated Product product,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "stock/new";

        productDAO.save(product);
        return "redirect:/stock";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("product", productDAO.show(id));
        return "stock/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("product") @Validated Product product, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "stock/edit";

        productDAO.update(id, product);
        return "redirect:/stock";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        productDAO.delete(id);
        return "redirect:/stock";
    }
}