package es.com.disastercode.springangularjs.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.com.disastercode.springangularjs.business.entity.CityEntity;
import es.com.disastercode.springangularjs.business.service.CityService;
import es.com.disastercode.springangularjs.business.service.CrudService;
import es.com.disastercode.springangularjs.business.service.criteria.CitySearchCriteria;
import es.com.disastercode.springangularjs.utils.PageWrapper;

@RequestMapping("/city")
@Controller
public class SampleController extends CrudController<CityEntity> {

	@Autowired
	private CityService cityService;

	public CrudService<CityEntity> getService(){
		return cityService;
	}
	
	public CityEntity getInstance(){
		return new CityEntity();
	}
	
	public String getItemName(){
		return "city";
	}	
	public String getItemsName(){
		return "cities";
	}


    @Override
    public String listItems(Model uiModel, Pageable page, HttpServletRequest request) {
        PageWrapper<CityEntity> pageNew = new PageWrapper<CityEntity> (cityService.findCities(new CitySearchCriteria(), page), "/city/list");
        uiModel.addAttribute("page", pageNew);
        uiModel.addAttribute("items", pageNew.getContent());
        uiModel.addAttribute("controller", "city");
        
        makeMessage(uiModel, request);
        return "city/cities";
    }
    
    
    
//    @RequestMapping("city/{id}")
//    public String showITem(@PathVariable Long id, Model model){
//        model.addAttribute("city", cityService.getItemById(id));
//    	model.addAttribute("mode", "readonly");
//        model.addAttribute("controller", "city");
//        return "city/detail";
//    }
//    
//    @RequestMapping("city")
//    public String showItem(Model model){
//    	model.addAttribute("city", new CityEntity());
//    	model.addAttribute("mode", "readonly");
//        model.addAttribute("controller", "city");
//        return "city/detail";
//    }
//    
//    
//
//    @RequestMapping("city/edit/{id}")
//    public String editItem(@PathVariable Long id, Model model){
//        model.addAttribute("city", cityService.getItemById(id));
//    	model.addAttribute("mode", "edit");
//        model.addAttribute("controller", "city");
//        return "city/detail";
//    }
//
//    @RequestMapping("city/new")
//    public String newItem(Model model){
//        model.addAttribute("city", new CityEntity());
//    	model.addAttribute("mode", "new");
//        model.addAttribute("controller", "city");
//    	return "city/detail";
//    }
//
//    @RequestMapping(value = "city", method = RequestMethod.POST)
//    public String saveItem(CityEntity item){
//        cityService.addItem(item);
//        return "redirect:/cities";
//    }
//
//    @RequestMapping("city/delete/{id}")
//    public String deleteItem(@PathVariable Long id){
//        cityService.deleteItem(id);
//        return "redirect:/cities?successMessage=message.remove.correct";
//    }
    
    
    
}