package com.example.demo.Controller;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.HistoryService;
import com.example.demo.Service.imp.HistoryServiceImpl;
import com.example.demo.entity.mysql.Comments;
import com.example.demo.entity.mysql.History;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class historyController {
@Resource
HistoryServiceImpl historyService;
@PostMapping("/History/insert")
@ResponseBody
public ResultJson insertHistory(@RequestBody History history) {
    return historyService.insertHistory(history);
}

    @DeleteMapping("/History/delete")
    @ResponseBody
    public ResultJson deleteHistory(@RequestBody History history) {
        return historyService.deleteHistory(history);
    }

    @GetMapping("/History/select")
    @ResponseBody
    public ResultJson selectHistory(@RequestBody History history) {
        return historyService.selectHistory(history);
    }
}


