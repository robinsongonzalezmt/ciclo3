/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.servicio;

import co.edu.usa.modelo.Box;
import co.edu.usa.repositorio.BoxRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cala0
 */

@Service
public class BoxServicio {
@Autowired

private BoxRepository boxRepository;
    
   public List<Box> getAll() {
   return (List<Box>) boxRepository.getAll();};
  
  public Optional<Box> getBox(int id) {return boxRepository.getBox(id);};
  
  public Box save(Box box) { 
       if (box.getId()== null){
           return boxRepository.save(box);
       }
       else
       {
          Optional<Box> co =  boxRepository.getBox(box.getId());
          if (co.isEmpty()){
              return boxRepository.save(box);
          }
          else
          {
              return box;
          }
       }
 
    }
 /**
  public Box update (Box box){
        if (box.getIdBox() != null){
            Optional<Box> e = boxRepository.getBox(box.getIdBox());
            if (!e.isEmpty()){
                if (box.getDescription()!= null){
                    e.get().setDescription(box.getDescription());
                }
                categoryRepository.save(e.get());
                return e.get();
            }
            else
            {
                return category;
            }
        }
        else
        {
            return category;
        }
    }
  
  public boolean deleteCategory (int id){
   
      alternativa de Delete
      Optional<Category> category = categoryRepository.getCategory(id);
      if (category.isEmpty()){
          return false;
      }
      else 
      {
          categoryRepository.delete(category.get());
          return true;
      }
      
      Boolean aBoolean = getCategory(id).map(
              category->{
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
        }
        */
   
}
     

