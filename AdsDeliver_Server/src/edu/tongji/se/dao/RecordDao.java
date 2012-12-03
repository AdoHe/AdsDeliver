/**
 * 
 */
package edu.tongji.se.dao;

import java.util.List;

import edu.tongji.se.model.Record;

/**
 * @author hezibo
 *
 */
public interface RecordDao 
{
	public void save(Record transientInstance);
	
	public void delete(Record persistentInstance);
	
	public Record findById( java.lang.Integer id);
	
	 public List<Record> findByProperty(String propertyName, Object value);
	 
	 public List<Record> findAll();
	 
	 public List<Record> findRe(final String userName, final int offset, final int length);

	 public int getCount(final String userName);
}
