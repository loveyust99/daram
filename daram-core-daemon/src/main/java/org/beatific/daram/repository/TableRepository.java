package org.beatific.daram.repository;

import java.io.IOException;

import org.beatific.daram.file.BufferedFile;
import org.beatific.daram.table.Column;
import org.beatific.daram.table.Table;
import org.beatific.ddirori.repository.OneStateRepository;
import org.beatific.ddirori.repository.Store;
import org.springframework.util.Assert;

@Store
public class TableRepository extends OneStateRepository<Table> {

	private static final String FILE_NAME = "C:/files";

	private void append(Object object) {

		Table table = getTable(object);
		BufferedFile file = null;
		
		try {
			file = BufferedFile.getNewInstance(FILE_NAME, "rw");
			for (Column column : table.getColumns()) {
				file.write(column.getValue());
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
//			try {
//				if(file != null)file.close();
//			} catch (IOException e) {}
		}
	}

	private Table getTable(Object object) {

		Table table = null;

		Assert.notNull(object);
		if (object instanceof Table)
			table = (Table) object;
		else
			throw new RuntimeException("Type Cast Exception : source["
					+ object.getClass().getName() + "], destination["
					+ Table.class.getName() + "]");

		return table;
	}

	@Override
	public void save(Object object) {

		append(object);
	}

	@Override
	public Table load(Object object) {
		return null;
	}

	@Override
	public void change(Object object) {
		append(object);

	}

	@Override
	public void remove(Object object) {

	}

}
