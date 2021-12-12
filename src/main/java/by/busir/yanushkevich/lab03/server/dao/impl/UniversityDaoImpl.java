package by.busir.yanushkevich.lab03.server.dao.impl;

import by.busir.yanushkevich.lab03.server.bean.Student;
import by.busir.yanushkevich.lab03.server.dao.DaoException;
import by.busir.yanushkevich.lab03.server.dao.UniversityDao;
import by.busir.yanushkevich.lab03.server.dao.parser.XMLParser;
import by.busir.yanushkevich.lab03.server.dao.parser.XMLParserException;
import by.busir.yanushkevich.lab03.server.dao.parser.impl.XMLUniversityParser;
import by.busir.yanushkevich.lab03.server.dao.writer.Writer;
import by.busir.yanushkevich.lab03.server.dao.writer.XMLWriterException;
import by.busir.yanushkevich.lab03.server.dao.writer.impl.WriterImpl;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UniversityDaoImpl implements UniversityDao {
    private final File dbFile = new File(
            Objects.requireNonNull(getClass().getClassLoader().getResource("students.xml")).getFile());
    private final File schemaFile = new File(
            Objects.requireNonNull(getClass().getClassLoader().getResource("students.xsd")).getFile());


    @Override
    public List<Student> getById(String id) throws DaoException {
        List<Student> students = new ArrayList<>();
        try {
            XMLParser parser = new XMLUniversityParser();
            List<Map<String, String>> studentsParams = parser.parse(dbFile);
            for (Map<String, String> params : studentsParams) {
                if (params.get("id").equals(id)) {
                    students.add(new Student(params));
                }
            }
            return students;
        } catch (XMLParserException | ParserConfigurationException | IOException | SAXException | ParseException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void add(Student appliance) throws DaoException {
        try {
            Writer xmlWriter = new WriterImpl();
            xmlWriter.append(dbFile, schemaFile, appliance);
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException | XMLWriterException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void edit(Student student) throws DaoException {
        try {
            Writer xmlWriter = new WriterImpl();
            xmlWriter.replace(dbFile, schemaFile, student);
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException | XMLWriterException e) {
            throw new DaoException(e);
        }
    }
}
