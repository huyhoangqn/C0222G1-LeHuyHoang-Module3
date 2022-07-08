package model.repository.service;

import model.bean.Service;
import model.bean.TypeRent;
import model.bean.TypeService;
import model.repository.DatabaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    private final String GET_ALL = "select * from dich_vu left join loai_dich_vu on dich_vu.ma_loai_dich_vu =" +
            " loai_dich_vu.ma_loai_dich_vu left join kieu_thue on kieu_thue.ma_kieu_thue = dich_vu.ma_kieu_thue;";
    private final String INSERT_INTO_SERVICE = "INSERT INTO `dich_vu` ( `ten_dich_vu`," +
            " `dien_tich`, `chi_phi_thue`, `so_nguoi_toi_da`, `ma_kieu_thue`, `ma_loai_dich_vu`, `tieu_chuan_phong`, " +
            "`mo_ta_tien_nghi_khac`, `dien_tich_ho_boi`, `so_tang`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final String GET_TYPE_RENT = "select * from kieu_thue where ma_kieu_thue=?;";
    private final String GET_TYPE_SERVICE = "select * from loai_dich_vu where ma_loai_dich_vu = ?;";
    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;

    public void insertService(Service service) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_SERVICE);
            preparedStatement.setString(1, service.getTenDichVu());
            preparedStatement.setDouble(2, service.getDienTich());
            preparedStatement.setDouble(3, service.getChiPhiThue());
            preparedStatement.setInt(4, service.getSoNguoiToiDa());
            preparedStatement.setInt(5, service.getMaKieuThue().getMaKieuThue());
            preparedStatement.setInt(6, service.getMaLoaiDichVu().getMaLoaiDichVu());
            preparedStatement.setString(7, service.getTieuChuanPhong());
            preparedStatement.setString(8, service.getTienNghiKhac());
            if (service.getDienTichHoBoi() != null) {
                preparedStatement.setString(9, service.getDienTichHoBoi());
            } else {
                preparedStatement.setNull(9, java.sql.Types.NULL);
            }
            if (service.getSoTang() != null) {
                preparedStatement.setString(10, service.getSoTang());
            } else {
                preparedStatement.setNull(10, java.sql.Types.NULL);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//
//    public void insertService(Service service, int idTypeRent, int idTypeService) {
//        connection = databaseRepository.connectDataBase();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_SERVICE);
//            preparedStatement.setString(1, service.getNameService());
//            preparedStatement.setInt(2, service.getAreaService());
//            preparedStatement.setDouble(3, service.getCostService());
//            preparedStatement.setInt(4, service.getMaxPeopleService());
//            preparedStatement.setInt(5, idTypeRent);
//            preparedStatement.setInt(6, idTypeService);
//            preparedStatement.setString(7, service.getStandardRoom());
//            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
//            if (service.getDienTichHoBoi() != null) {
//                preparedStatement.setDouble(9, service.getAreaPool());
//            } else {
//                preparedStatement.setNull(9, java.sql.Types.NULL);
//            }
//            if (service.getNumberOfFloors() != null) {
//                preparedStatement.setInt(10, service.getNumberOfFloors());
//            } else {
//                preparedStatement.setNull(10, java.sql.Types.NULL);
//            }
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }


    public TypeRent findTypeRentById(int id) {
        TypeRent typeRent = null;
        try {
            connection = databaseRepository.connectDataBase();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TYPE_RENT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int iDTypeRent = resultSet.getInt(1);
                String nameTypeRent = resultSet.getNString(2);
                typeRent = new TypeRent(iDTypeRent, nameTypeRent);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeRent;
    }

    public TypeService findTypeServiceById(int id) {
        TypeService typeService = null;
        try {
            connection = databaseRepository.connectDataBase();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TYPE_SERVICE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int iDTypeService = resultSet.getInt(1);
                String nameTypeService = resultSet.getNString(2);
                typeService = new TypeService(iDTypeService, nameTypeService);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeService;
    }


    public List<Service> findAll() {
        List<Service> services = new ArrayList<>();
        try {
            connection = databaseRepository.connectDataBase();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String nameService = resultSet.getString(2);
                double areaService = resultSet.getDouble(3);
                double costService = resultSet.getDouble(4);
                int maxPeopleService = resultSet.getInt(5);
                int idTypeRent = resultSet.getInt(6);
                TypeRent typeRent = findTypeRentById(idTypeRent);
                int typeServiceId = resultSet.getInt(7);
                TypeService typeService = findTypeServiceById(typeServiceId);
                String standardRoom = resultSet.getString(8);
                String OtherConvenience = resultSet.getString(9);
                String areaPool = resultSet.getString(10);
                String numberOfFloors = resultSet.getString(11);

                Service service = new Service(id, nameService, areaService, costService, maxPeopleService,
                        typeRent, typeService, standardRoom, OtherConvenience, areaPool, numberOfFloors);
                services.add(service);
            }
            return services;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public void insertService(Service service, int idTypeRent, int idTypeService) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_SERVICE);
            preparedStatement.setString(1, service.getTenDichVu());
            preparedStatement.setDouble(2, service.getDienTich());
            preparedStatement.setDouble(3, service.getChiPhiThue());
            preparedStatement.setInt(4, service.getSoNguoiToiDa());
            preparedStatement.setInt(5, idTypeRent);
            preparedStatement.setInt(6, idTypeService);
            preparedStatement.setString(7, service.getTieuChuanPhong());
            preparedStatement.setString(8, service.getTienNghiKhac());
            if (service.getDienTichHoBoi() != null) {
                preparedStatement.setString(9, service.getDienTichHoBoi());
            } else {
                preparedStatement.setNull(9, java.sql.Types.NULL);
            }
            if (service.getSoTang() != null) {
                preparedStatement.setString(10, service.getSoTang());
            } else {
                preparedStatement.setNull(10, java.sql.Types.NULL);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
