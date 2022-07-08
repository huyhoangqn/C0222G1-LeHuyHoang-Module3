package model.service.contract.contract_detail;

import model.bean.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> getAll();

    List<ContractDetail> findByContractId(int idContract);

    void add(ContractDetail contractDetail);

    void add(ContractDetail contractDetail, int idContract, int idAttach);
}
