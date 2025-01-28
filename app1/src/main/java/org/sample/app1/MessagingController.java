package org.sample.app1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingController {

  @Autowired
  private MessagingService service;

  @PostMapping("/shuffle/{num}")
  public void shuffle(@PathVariable int num) {
    service.sendMessage(num);
  }
}
