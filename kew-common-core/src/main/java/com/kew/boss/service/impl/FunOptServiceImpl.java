package com.kew.boss.service.impl;

import com.kew.page.Page;
import com.kew.boss.mapper.FunOptMapper;
import com.kew.boss.model.FunOpt;
import com.kew.boss.service.FunOptService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FunOptServiceImpl implements FunOptService
{
    @Autowired
    private FunOptMapper funOptMapper;
    
    @Transactional(readOnly = true)
    public List<FunOpt> data()
    {
        return funOptMapper.data();
    }

    public void add(FunOpt entity)
    {
         funOptMapper.add(entity);
    }

    public void update(FunOpt entity)
    {
         funOptMapper.update(entity);
    }

    public void del(FunOpt entity)
    {
         funOptMapper.del(entity);   
    }

    @Transactional(readOnly = true)
    public FunOpt findById(Object o)
    {
        return funOptMapper.findById(o);
    }

    @Transactional(readOnly = true)
    public List<FunOpt> findByRoleUnFunOpt(long roleid)
    {
        return funOptMapper.findByRoleUnFunOpt(roleid);
    }

    @Transactional(readOnly = true)
    public List<FunOpt> findByRoleFunOpt(long roleid)
    {
        return funOptMapper.findByRoleFunOpt(roleid);
    }

    @Transactional(readOnly = true)
	public List<FunOpt> getFunOptByCondition(FunOpt funOpt,RowBounds rowBounds) {
		return funOptMapper.findFunOptByFunOpt(funOpt,rowBounds);
	}

    @Transactional(readOnly = true)
	public int getTotal(FunOpt funOpt) {
		return funOptMapper.getTotal(funOpt);
	}

    @Transactional(readOnly = true)
	public List<String> getFunOptUrlByUserId(long userId) {
		return funOptMapper.getFunOptUrlByUserId(userId);
	}

    @Transactional(readOnly = true)
	@Override
	public Page<FunOpt> getPageModel(FunOpt funOpt, RowBounds rowBounds) {
		int total = funOptMapper.getTotal(funOpt);
		List<FunOpt> list = funOptMapper.findFunOptByFunOpt(funOpt, rowBounds);
		Page<FunOpt> myPage = new Page<FunOpt>(total,list);
		return myPage;
	}

	/**
	 * 判断是否能删除该资源
	 * @param funOpt
	 * @return true可以删除 false不能删除
	 */
	@Override
	@Transactional(readOnly = true)
	public boolean isCouldDelete(FunOpt funOpt) {
		if(funOpt!=null){
			long number = funOptMapper.isCouldDelete(funOpt.getFunOptId());
			if(number==0){
				return true;
			}
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public FunOpt getByUrl(String url) {
		return funOptMapper.getByUrl(url);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isValidUrl(String url) {
		 FunOpt funopt = funOptMapper.getByUrl(url);
		 if(funopt!=null){
			 return false;
		 }
		 return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isValidUrl(String url, long funOptId) {
		 FunOpt funopt = funOptMapper.getByUrlNotFunOptId(url,funOptId);
		 if(funopt!=null){
			 return false;
		 }
		 return true;
	}
}
