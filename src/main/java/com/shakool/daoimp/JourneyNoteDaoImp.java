package com.shakool.daoimp;

import com.shakool.dao.JourneyNoteDao;
import com.shakool.pojo.JourneyNote;
import com.shakool.query.JourneyNoteQuery;
import com.shakool.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by nibnait on 5/22/16.
 */
@Repository
public class JourneyNoteDaoImp implements JourneyNoteDao{

/*
    SqlSession sqlSession = null;
    try{
        sqlSession = MyBatisUtils.getSession();
        sqlSession.insert("com.shakool.com.shakool.mapper.mapper.JourneyNoteMapper.addJourneyNote",journeyNote);
        sqlSession.commit();
    }catch (IOException e){
        e.printStackTrace();
    }finally {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    */

    public void addJourneyNote(JourneyNote journeyNote) {
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.getSession();
            sqlSession.insert("com.shakool.dao.JourneyNoteDao.addJourneyNote",journeyNote);
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public List<JourneyNote> getJourneyNoteListWithPage(JourneyNoteQuery journeyNoteQuery) {
        SqlSession sqlSession = null;
        List<JourneyNote> journeyNotes = null;
        try{
            sqlSession = MyBatisUtils.getSession();
            journeyNotes = sqlSession.selectList("com.shakool.dao.JourneyNoteDao.getJourneyNoteListWithPage",
                    journeyNoteQuery);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return journeyNotes;
    }

    public void updateJourneyNoteByKey(JourneyNote journeyNote){
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.getSession();
            sqlSession.update("com.shakool.dao.JourneyNoteDao.updateJourneyNoteByKey",journeyNote);
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void deleteByKey(String id) {
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.getSession();
            sqlSession.delete("com.shakool.dao.JourneyNoteDao.deleteByKey",id);
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void deleteByKeys(List<String> ids) {
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtils.getSession();
            sqlSession.delete("com.shakool.dao.JourneyNoteDao.deleteByKeys",ids);
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
