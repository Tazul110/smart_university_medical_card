package com.example.demo.sms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import javax.sql.rowset.serial.SerialException;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.example.demo.sms.Model.Prescription;
import com.example.demo.sms.Model.Student;
import com.example.demo.sms.Repository.EmailsRepository;
import com.example.demo.sms.Repository.MedicineRepository;
import com.example.demo.sms.Repository.PrescriptionRepository;
import com.example.demo.sms.Repository.StudentRepository;
import com.example.demo.sms.Service.EmailService;
import com.example.demo.sms.Service.StudentService;
import com.example.demo.sms.Model.Emails;
import com.example.demo.sms.Model.Medicine;
@Controller
public class MedicalController {

	@Autowired
	private StudentService studentService;
	
	
//start 1..................................................................................
	@GetMapping("/prescription_form")
	public String index(@RequestParam(name = "studentId") String studentId, Model model) {
	    // Set the studentId as an attribute in the model
	    model.addAttribute("studentId", studentId);
	    return "prescription_form";
	}
    
    @Autowired
	 private PrescriptionRepository prescriptionRepository;
	 
    @RequestMapping("/save_prescription")
    public String savePrescription(
            @RequestParam String medication,
            @RequestParam String dosage,
            //@RequestParam String instructions,
            //@RequestParam long refills,
            @RequestParam String studentId,Model model) {
        Student student = studentRepository.findById(studentId).orElse(null);
        
        if (student == null) {
            
            return "redirect:/";
        }
        
        // Create a new Prescription object and save it using the repository
        Prescription prescription = new Prescription();
        prescription.setMedication(medication);
        prescription.setDosage(dosage);
        //prescription.setInstructions(instructions);
        //prescription.setRefill(refills);
        prescription.setStudent(student);
        prescriptionRepository.save(prescription);
         
        //this is for redirect to searched student page;
       
	        Student student1 = studentRepository.findById(studentId).orElse(null);
	        if (student1 != null) {
	            model.addAttribute("student", student1);
	        }
	        return "searched_student";
	    
	         
        //return "redirect:/id";
    }

//end 1........................................................................................ 
    

    
    
//start 2 ....................................................................................   
	 @GetMapping("/Show_all_Students")
	    public String showStudents(Model model) {
	        List<Student> students = studentService.getAllStudents();
	        model.addAttribute("students", students);
	        return "students_demo";
	    }
	 
	 @GetMapping("/display")
	    public ResponseEntity<byte[]> displayImage(@RequestParam("id") String id) throws IOException, SQLException
	    {
	        Student image=studentService.viewById(id);
	        byte [] imageBytes = null;
	        imageBytes = image.getImage().getBytes(1,(int) image.getImage().length());
	        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	    }
//end 2.......................................................................................	    
	    

	    
	    
//start 3....................................................................................	    	   	    	
	@RequestMapping("/createAccount")
	public String Account(Model model)
	{
		//return "account";
		model.addAttribute("type", "Author");
		return "login";
	}
		
	@PostMapping("/Created_student_account")
    public String addImagePost(@RequestParam("studentName") String name, 
    		@RequestParam("gender") String gender,
    		@RequestParam("studentId") String id,
    		@RequestParam("department") String dept,
    		@RequestParam("dateOfBirth") String dateOfBirth,
    		@RequestParam("studentEmail") String email,
    		@RequestParam("image") MultipartFile file) throws IOException, SerialException, SQLException
    {
		 byte[] bytes = file.getBytes();
	     Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
        Student student = new Student();
        student.setS_Id(id);
        student.setS_Name(name);
        student.setS_Gender(gender);
        student.setS_Dept(dept);
        student.setB_Date(dateOfBirth);
        student.setEmail(email);
        student.setImage(blob);
        studentService.create(student);
        return "redirect:/createAccount";
    }
//end 3.......................................................................................	 


	
	
	
//start 4....................................................................................	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/id")
	public String SearchById(Model model)
	{
		model.addAttribute("type", "Doctors");
		//return "search_id";
		return "login";
	}
	
	 @GetMapping("/searched_id")
	    public String getStudent(@RequestParam String id, Model model) {
		 
	        Student student = studentRepository.findById(id).orElse(null);
	        if (student != null) {
	            model.addAttribute("student", student);
	        }
	        return "searched_student";
	    }
//end 4.......................................................................................

	 
	 
	 
	 
//start 5.......................................................................................
	
	 @GetMapping("/")
	 public String HomePage()
	 {
		 return "home_page";
	 }
	 
//end 5	.......................................................................................... 

	 
	 
	 
	 
//start 6.......................................................................................
	 
	 @Autowired
	    private MedicineRepository medicineRepository;
	 
	 @GetMapping("/medicine_form")
	    public String medicineForm(@RequestParam(name = "prescriptionId") long prescriptionId,
	    		@RequestParam(name = "studentId") String studentId, Model model) {
		    // Set the studentId as an attribute in the model
		    model.addAttribute("prescriptionId", prescriptionId);
		    model.addAttribute("studentId", studentId); 
	        return "medicine"; 
	    }

	    @PostMapping("/addMedicine")
	    public String addMedicine(
	            @RequestParam("medicineName") String name,
	            @RequestParam("medicineType") String type,
	            @RequestParam("consumtionRule") String rule,
	            @RequestParam("medicineDays") String days,
	            @RequestParam("prescriptionId") long prescriptionId,
	            @RequestParam("studentId") String studentId,
	            Model model) {
	        Prescription prescription = prescriptionRepository.findById(prescriptionId).orElse(null);

	        if (prescription == null) {
	            return "redirect:/medicine_form";
	        }

	        Medicine medicine = new Medicine();
	        medicine.setM_name(name);
	        medicine.setM_type(type);
	        medicine.setConsumption_rule(rule);
	        medicine.setM_days(days);
	        medicine.setPrescription(prescription);
	        medicineRepository.save(medicine);
	        model.addAttribute("prescriptionId", prescriptionId);
	        model.addAttribute("studentId", studentId);
	        
	        Student student =studentRepository.findById(studentId).orElse(null);
	        
	        if (student != null && !student.getEmail().isEmpty()) {
	        	
	        	String to = student.getEmail();
	        	String subject = "Added Medicine";
	 	        String body = name+" Medicine is added to your prescription By MBSTU Medical";
	 	        emailService.sendSimpleEmail(to, subject, body);
	            
	        }
	        return "medicine"; 
	    }

//end 6........................................................................................

	    
	    
	    
//start 7.......................................................................................
	    @RequestMapping("/login")
	    public String LogIn()
	    {
	    	return "login";
	    }
	    
	    @Autowired
	    private EmailsRepository emailsRepository;
	    
	    @RequestMapping("/check_password")
	    public String loggedIn(@RequestParam("username") String username, 
	    		@RequestParam("password") String password,
	    		@RequestParam("type") String type) 
	    {
	        // Find the user in the database by username
	        Optional<Emails> userOptional = emailsRepository.findById(username);

	        if (userOptional.isPresent()) {
	            Emails user = userOptional.get();

	            // Check if the provided password matches the stored password
	            if (user.getPassword().equals(password)) {
	                // Password matches, consider the email as verified
	            	if(type.equals("Author"))
	            		return "account";
	            	else
	                return "search_id";
	            } else {
	                return "Incorrect_Password";
	            }
	        } else {
	            return "Email_not_found"; // User with the provided email not found
	        }
	    }
	    
//end   7.........................................................................................

	    
	    
// start 8........................Email...................................................
	    @Autowired
	    private EmailService emailService;

	    @RequestMapping("/send-email")
	    public String sendEmail() {
	        String to = "tazulislam110111@gmail.com";
	        String subject = "test";
	        String body = "This is a test email.";

	        emailService.sendSimpleEmail(to, subject, body);
	        return "Email sent successfully!";
	    }
	    
//end 8...................................................................................
}
