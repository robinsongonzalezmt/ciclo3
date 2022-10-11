/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.servicio;

import co.edu.usa.modelo.Message;
import co.edu.usa.repositorio.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cala0
 */

@Service
public class MessageServicio {
@Autowired
    private MessageRepository messageRepository;
    
   public List<Message> getAll() {
   return (List<Message>) messageRepository.getAll();};
  
  public Optional<Message> getMessage(int id) {return messageRepository.getMessage(id);};
  
  public Message save(Message message) { 
       if (message.getIdMessage()== null){
           return messageRepository.save(message);
       }
       else
       {
          Optional<Message> co =  messageRepository.getMessage(message.getIdMessage());
          if (co.isEmpty()){
              return messageRepository.save(message);
          }
          else
          {
              return message;
          }
       }
 
    }
/**
  public Message update (Message message){
        if (message.getIdMessage() != null){
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if (!e.isEmpty()){
                if (message.getDescription()!= null){
                    e.get().setDescription(message.getDescription());
                }
                messageRepository.save(e.get());
                return e.get();
            }
            else
            {
                return message;
            }
        }
        else
        {
            return message;
        }
    }

  public boolean deleteMessage (int id){
   
      /** alternativa de Delete
      Optional<Category> category = categoryRepository.getCategory(id);
      if (category.isEmpty()){
          return false;
      }
      else 
      {
          categoryRepository.delete(category.get());
          return true;
      }
      
      
    Boolean aBoolean = getMessage(id).map(
              category->{
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    */
}
        
