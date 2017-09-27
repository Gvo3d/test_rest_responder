package org.yakimovdenis.test_rest_responder;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private final String SEPARATOR = "**************************************************";

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> getResponse(){
        Response response = new Response();
        response.setText("text data");
        response.setUrl("url data");
        response.setImage("image data");
        response.setStyle("style data");
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/data", params = {"text", "url", "image", "style"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Response>> getResponse2(@RequestParam(name = "text") String text, @RequestParam(name = "url") String url, @RequestParam(name = "image") String image, @RequestParam(name = "style") String style){
        List resultList = new ArrayList<>();
        for (int i=0;i<10;i++){
        Response response = new Response();
        response.setText(text+i);
        response.setUrl(url+i);
        response.setImage(image+i);
        response.setStyle(style+i);
        resultList.add(response);
        }
        return new ResponseEntity<List<Response>>(resultList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/print", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void printText(@RequestBody Request object){
        System.out.println(SEPARATOR);
        System.out.println(object.toString());
    }
}
