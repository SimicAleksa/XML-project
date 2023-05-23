package com.example.XML_WS_Patent_backend.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "onlyApproved",
        "statusFilter",
        "emailNalogaPodnosiocaFilter",
        "datumPodnosenjaFilter"
})
@XmlRootElement(name = "ComplexSearchParamsDTO")
public class ComplexSearchParamsDTO {
    @XmlElement
    private Boolean onlyApproved;
    @XmlElement
    private List<StatusFilterDTO> statusFilter;
    @XmlElement
    private List<EmailNalogaPodnosiocaFilterDTO> emailNalogaPodnosiocaFilter;
    @XmlElement
    private List<DatumPodnosenjaFilterDTO> datumPodnosenjaFilter;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "toNeg",
            "value",
            "followingOperator"
    })
    @XmlRootElement(name = "StatusFilterDTO")
    public static class StatusFilterDTO {
        @XmlElement
        private Boolean toNeg;
        @XmlElement
        private String value;
        @XmlElement
        private String followingOperator;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "toNeg",
            "value",
            "followingOperator"
    })
    @XmlRootElement(name = "EmailNalogaPodnosiocaFilterDTO")
    public static class EmailNalogaPodnosiocaFilterDTO {
        @XmlElement
        private Boolean toNeg;
        @XmlElement
        private String value;
        @XmlElement
        private String followingOperator;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value",
            "dateOperator",
            "followingOperator"
    })
    @XmlRootElement(name = "DatumPodnosenjaFilterDTO")
    public static class DatumPodnosenjaFilterDTO {
        @XmlElement
        private String value;
        @XmlElement
        private String dateOperator;
        @XmlElement
        private String followingOperator;

    }

}


