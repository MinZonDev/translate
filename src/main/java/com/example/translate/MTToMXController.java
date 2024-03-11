package com.example.translate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MTToMXController {

    @PostMapping("/convert")
    public ResponseEntity<String> convertMTToMX(@RequestBody String mtMessage) {
        // Xử lý chuyển đổi từ tin nhắn MT sang tin nhắn MX
        MTMessage mt = new MTMessage(mtMessage);
        MXMessage mx = MTToMXConverter.convertMTToMX(mt);
        // Trả về đoạn mã MX
        if (mx != null) {
            return ResponseEntity.ok(mx.getBody());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to convert MT to MX.");
        }
    }
}
