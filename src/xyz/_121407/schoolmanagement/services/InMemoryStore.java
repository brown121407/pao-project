package xyz._121407.schoolmanagement.services;

import xyz._121407.schoolmanagement.entities.*;
import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.repositories.Repository;

public class InMemoryStore {
    private static InMemoryStore instance;

    private final Repository<Address> addressRepository = new Repository<>();
    private final Repository<Class> classRepository = new Repository<>();
    private final Repository<Grade> gradeRepository = new Repository<>();
    private final Repository<Parent> parentRepository = new Repository<>();
    private final Repository<Profile> profileRepository = new Repository<>();
    private final Repository<Room> roomRepository = new Repository<>();
    private final Repository<Student> studentRepository = new Repository<>();
    private final Repository<Subject> subjectRepository = new Repository<>();
    private final Repository<Teacher> teacherRepository = new Repository<>();

    private InMemoryStore() {

    }

    public static InMemoryStore getInstance() {
        if (instance == null) {
            instance = new InMemoryStore();
        }

        return instance;
    }

    public Repository<Address> getAddressRepository() {
        return addressRepository;
    }

    public Repository<Class> getClassRepository() {
        return classRepository;
    }

    public Repository<Grade> getGradeRepository() {
        return gradeRepository;
    }

    public Repository<Parent> getParentRepository() {
        return parentRepository;
    }

    public Repository<Profile> getProfileRepository() {
        return profileRepository;
    }

    public Repository<Room> getRoomRepository() {
        return roomRepository;
    }

    public Repository<Student> getStudentRepository() {
        return studentRepository;
    }

    public Repository<Subject> getSubjectRepository() {
        return subjectRepository;
    }

    public Repository<Teacher> getTeacherRepository() {
        return teacherRepository;
    }
}
