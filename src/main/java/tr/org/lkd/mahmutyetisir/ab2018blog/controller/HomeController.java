package tr.org.lkd.mahmutyetisir.ab2018blog.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tr.org.lkd.mahmutyetisir.ab2018blog.Repository.EntryRepository;
import tr.org.lkd.mahmutyetisir.ab2018blog.model.Entry;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/blog")
public class HomeController {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getIndex(Model model){

        Iterable<Entry> entries = entryRepository.findAll();
        model.addAttribute("entries",entries);
        entryRepository.findAll();

        return "entries/listEntries";
    }

    @RequestMapping(value = "/beans", method = RequestMethod.GET)
    public String getBeans(Model model){
        model.addAttribute("beans",applicationContext.getBeanDefinitionNames());
        return "listBeans";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getEntryForm(Model model){
        model.addAttribute("entry", new Entry());
        return "entries/newEntry";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String postEntryForm(@Valid @ModelAttribute Entry entry, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "entries/newEntry";
        }
        else {
            entryRepository.save(entry);
            System.out.println(entry.toString());
            return "redirect:/blog";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showEntry(@PathVariable("id") Integer id, Model model){
        Optional<Entry> optionalEntry = entryRepository.findById(id);
        if(!optionalEntry.isPresent()){
            log.warn("Entry with {} id is not present", id);
            return "index";
        }
        else {
            model.addAttribute("showEntry" ,optionalEntry.get());
            return "entries/showEntry";
        }

    }

}
