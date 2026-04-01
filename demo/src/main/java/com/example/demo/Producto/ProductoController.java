package com.example.demo.Producto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // Listar
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", service.listarTodos());
        return "productos/list";
    }

    // Mostrar formulario crear
    @GetMapping("/nuevo")
    public String nuevoFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/form";
    }

    // Guardar (nuevo o editar)
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto, RedirectAttributes ra) {
        service.guardar(producto);
        ra.addFlashAttribute("msg", "Guardado correctamente");
        return "redirect:/productos";
    }

    // Editar (cargar formulario)
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes ra) {
        return service.obtenerPorId(id).map(p -> {
            model.addAttribute("producto", p);
            return "productos/form";
        }).orElseGet(() -> {
            ra.addFlashAttribute("msg", "Producto no encontrado");
            return "redirect:/productos";
        });
    }

    // Eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes ra) {
        service.eliminar(id);
        ra.addFlashAttribute("msg", "Eliminado correctamente");
        return "redirect:/productos";
    }
}
