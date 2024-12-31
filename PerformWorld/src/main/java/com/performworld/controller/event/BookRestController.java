package com.performworld.controller.event;

import com.performworld.dto.ticket.TicketingDTO;
import com.performworld.service.event.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;

    // 5분 내로 시작되는 특정 공연 티켓팅 조회
    @PostMapping("/getRecentTicketing")
    public List<TicketingDTO> getRecentTicketing(@RequestBody TicketingDTO ticketingDTO) {
        log.info(ticketingDTO);
        return bookService.findRecentTicketing(ticketingDTO.getEventId());
    }

    // 특정 공연의 모든 티켓팅 조회
    @PostMapping("/getEventTicketing")
    public List<TicketingDTO> getEventTicketing(@RequestBody TicketingDTO ticketingDTO) {
        log.info(ticketingDTO);
        return bookService.getEventTicketing(ticketingDTO.getEventId());
    }
}
