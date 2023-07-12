package hi1237.hello.boot.spring5boot.mybatis;

import hi1237.hello.boot.spring5boot.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



@Mapper
public interface BoardMapper {

    int insertBoard(Board b);

    List<Board> selectBoard();

    Board selectOneBoard(String bno);



}