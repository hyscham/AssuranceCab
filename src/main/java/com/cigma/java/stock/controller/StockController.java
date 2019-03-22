package com.cigma.java.stock.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cigma.java.stock.entities.StockCategorie;
import com.cigma.java.stock.entities.StockSupplier;
import com.cigma.java.stock.services.StockCategoryService;
import com.cigma.java.stock.services.StockSupplierService;



@Controller
@Secured(value = { "ROLE_ADMIN" })
public class StockController {

	@Autowired
	private StockCategoryService stockCategoryService;
	
	@Autowired
	private StockSupplierService stockSupplierService;
	
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	
	//Rendering Form
	@GetMapping("/stock/category")
	public String formAddStockCat(Model m) {
		m.addAttribute("category",new StockCategorie());
		
		return "stock/formAddCategory";
	}

	
	//Handling Form
	@PostMapping(value="/stock/category/add")
	public String addStockCat(
								@ModelAttribute("category") @Valid StockCategorie stockCategory, 
								BindingResult bindingResult, 
								Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("msg","Some Errors occured when try to saving !");
						
			return "stock/formAddCategory";
		}
		
		stockCategoryService.saveCategory(stockCategory);
		model.addAttribute("msg", "Category "+stockCategory.getCategoryDescription().toUpperCase() + " has been created.");
		model.addAttribute("category",new StockCategorie());

		return "stock/formAddCategory";
		
	}
	//*********************************************Fournisseur ******************************************
	

	//Rendering Form Supplier
		@GetMapping("/stock/supplier")
		public String formAddStockSup(@RequestParam(value="idSupplier",required = false) Integer id, Model m) {
			StockSupplier st;
			if (id == null) {
				st= new StockSupplier();
				m.addAttribute("msg","Nouveau ..;");

			}else {
				try {
					st=stockSupplierService.getSupplierById(id);
					System.out.println(st.getSupplierName());
					m.addAttribute("msg","Update "+st.getSupplierName());
				}catch(Exception e) {
					st=new StockSupplier();
				}
			}
				
			m.addAttribute("fournisseur",st);
			return "stock/formAddSupplier";
		}

		//Delete 
		@GetMapping("/stock/supplier/del")
		public String deleteSupplier(@RequestParam(value="idSupplier") Integer id,
				RedirectAttributes redirectAttributes) {
			
			stockSupplierService.delete(id);
			redirectAttributes.addAttribute("id",null);
			
			return "redirect:/stock/supplier";
		}
		
		//Handling Form Supplier@PostMapping
		@RequestMapping(value="/stock/supplier/add",params= "save")
		public String addStockSup(
									@ModelAttribute("fournisseur") @Valid StockSupplier stockSupplier, 
									BindingResult bindingResult, 
									Model model) {
			
			if (bindingResult.hasErrors()) {
				model.addAttribute("msg","Some Errors occured when try to saving !");
							
				return "stock/formAddSupplier";
			}

			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.out.println(stockSupplier.getSupplierId());
			System.out.println(stockSupplier.getSupplierName());
			System.out.println(stockSupplier.getSupplierShdes());
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			
			stockSupplierService.saveSupplier(stockSupplier);
			model.addAttribute("msg", "Supplier  "+stockSupplier.getSupplierName().toUpperCase() + " has been created.");
			model.addAttribute("category",new StockSupplier());
			

				return "redirect:/stock/supplier";
			
			
		}
		
		//@PostMapping
		@RequestMapping(value="/stock/supplier/add",params= "search")
		public String searchStockSup(@ModelAttribute("fournisseur") StockSupplier stockSupplier, Model model) {
			
			List<StockSupplier> supList = new ArrayList<>();
			supList = stockSupplierService.findStockSupplierByName(stockSupplier.getSupplierName().toLowerCase());
			model.addAttribute("suppliers",supList);
			model.addAttribute("msg", "Resulta de la recherche pour " +stockSupplier.getSupplierName());
			//model.addAttribute("category",new StockSupplier());
			

			return "stock/listSuppliers";
			
			
		}
	
	
	
}
