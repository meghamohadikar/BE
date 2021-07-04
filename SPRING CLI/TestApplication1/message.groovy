@Controller
@Grab('spring-boot-starter-thymeleaf')

class MessageController {
   @RequestMapping("/message")
   
   String getMessage(Model model) {
	System.out.println("Model=="+Model)
      String message = "Welcome to TutorialsPoint.Com!";
      model.addAttribute("message", message);
      return "message";
   }
} 