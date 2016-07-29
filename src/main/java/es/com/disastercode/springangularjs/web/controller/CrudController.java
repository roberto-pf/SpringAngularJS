package es.com.disastercode.springangularjs.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.com.disastercode.springangularjs.business.service.CrudService;

public abstract class CrudController<T> {

	@Autowired
	private MessageSource messageSource;

	public abstract CrudService<T> getService();
	public abstract T getInstance();
	public abstract String getItemName();
	public abstract String getItemsName();
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public abstract String listItems(Model uiModel, Pageable page, HttpServletRequest request);
    
    protected void makeMessage(Model uiModel, HttpServletRequest request){
        String msg = "";
        if(request.getParameter("successMessage")!=null)
	        msg = messageSource.getMessage(request.getParameter("successMessage").toString(),null,LocaleContextHolder.getLocale());
        uiModel.addAttribute("successMessage", msg);
        
        msg = "";
        if(request.getParameter("dangerMessage")!=null)
	        msg = messageSource.getMessage(request.getParameter("dangerMessage").toString(),null,LocaleContextHolder.getLocale());
        uiModel.addAttribute("dangerMessage", msg);
    }
    
    
    
    @RequestMapping("/{id}")
    public String showITem(@PathVariable Long id, Model model){
        model.addAttribute(getItemName(), getService().getItemById(id));
    	model.addAttribute("mode", "readonly");
        model.addAttribute("controller", getItemName());
        return getItemName() + "/detail";
    }
    
    @RequestMapping("")
    public String showItem(Model model){
    	model.addAttribute(getItemName(), getInstance());
    	model.addAttribute("mode", "readonly");
        model.addAttribute("controller", getItemName());
        return getItemName() + "/detail";
    }
    
    

    @RequestMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model){
        model.addAttribute(getItemName(), getService().getItemById(id));
    	model.addAttribute("mode", "edit");
        model.addAttribute("controller", getItemName());
        return getItemName() + "/detail";
    }

    @RequestMapping("/new")
    public String newItem(Model model){
        model.addAttribute(getItemName(), getInstance());
    	model.addAttribute("mode", "new");
        model.addAttribute("controller", getItemName());
    	return getItemName() + "/detail";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveItem(T item){
    	getService().addItem(item);
        return "redirect:/"+getItemName()+"/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id){
    	getService().deleteItem(id);
        return "redirect:/"+getItemName()+"/list?successMessage=message.remove.correct";
    }
    
    
    
}