package model.repository.contract_detail;

import model.bean.*;
import model.repository.DatabaseRepository;
import model.service.attach_service.AttachServiceImpl;
import model.service.attach_service.AttachServiceService;
import model.service.contract.ContractService;
import model.service.contract.ContractServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository {
    private static final String GET_ALL = "SELECT * FROM contract_detail";
    private static final String FIND_BY_ID_CONTRACT = "select * from " +
            " contract_detail inner join attach_service `as` on contract_detail.attach_service_id = `as`.attach_service_id\n" +
            " where contract_id = ?";
    private static final String INSERT_INTO = "INSERT INTO contract_detail " +
            "(contract_id, attach_service_id, quantity) " +
            "VALUES (?, ?, ?)";
    DatabaseRepository databaseRepository = new DatabaseRepository();
    ContractService contractService = new ContractServiceImpl();
    AttachServiceService attachServiceService = new AttachServiceImpl();

    public List<ContractDetail> findAll() {
        Connection connection = databaseRepository.connectDataBase();
        List<ContractDetail> contractDetails = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("contract_detail_id");
                int idContract = resultSet.getInt("contract_id");
                Contract contract = contractService.findById(id);
                int idAttachService = resultSet.getInt("attach_service_id");
                AttachService attachService = attachServiceService.findById(idAttachService);
                int quantity = resultSet.getInt("quantity");
                ContractDetail contractDetail = new ContractDetail(id, contract, attachService, quantity);
                contractDetails.add(contractDetail);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractDetails;
    }

    public List<ContractDetail> findByContractId(int idContract) {
        Connection connection = databaseRepository.connectDataBase();
        List<ContractDetail> contractDetails = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_CONTRACT);
            preparedStatement.setInt(1, idContract);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("contract_detail_id");
                int idContract1 = resultSet.getInt("contract_id");
                Contract contract = contractService.findById(idContract1);
                int idAttach = resultSet.getInt("attach_service_id");
                AttachService attachService = attachServiceService.findById(idAttach);
                int quantity = resultSet.getInt("quantity");
                ContractDetail contractDetail = new ContractDetail(id, contract, attachService, quantity);
                contractDetails.add(contractDetail);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractDetails;
    }

    public void insertContractDetail(ContractDetail contractDetail) {
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1, contractDetail.getContract().getId());
            preparedStatement.setInt(2, contractDetail.getAttachService().getIdAttach());
            preparedStatement.setInt(3, contractDetail.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertContractDetail(ContractDetail contractDetail, int idContract, int idAttach) {
        Connection connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1, idContract);
            preparedStatement.setInt(2, idAttach);
            preparedStatement.setInt(3, contractDetail.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
