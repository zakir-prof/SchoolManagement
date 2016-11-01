package com.accolite.school.transport;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.apache.axis2.AxisFault;

import com.accolite.www.schemas.school.transport.applicationheader_xsd.ApplicationHeaderDocument.ApplicationHeader;
import com.accolite.www.schemas.school.transport.createtransportrequest_xsd.CreateTransportRequestDocument;
import com.accolite.www.schemas.school.transport.createtransportrequest_xsd.CreateTransportRequestDocument.CreateTransportRequest;
import com.accolite.www.schemas.school.transport.createtransportrequest_xsd.CreateTransportRequestDocument.CreateTransportRequest.DataHeader;
import com.accolite.www.schemas.school.transport.createtransportrequest_xsd.DriverDocument.Driver;
import com.accolite.www.schemas.school.transport.createtransportrequest_xsd.SchoolDocument.School;
import com.accolite.www.schemas.school.transport.createtransportrequest_xsd.TransportDocument.Transport;
import com.accolite.www.schemas.school.transport.createtransportresponse_xsd.CreateTransportResponseDocument;
import com.accolite.www.schemas.school.transport.createtransportresponse_xsd.CreateTransportResponseDocument.CreateTransportResponse;


public class TransportCheck {

	public static void main(String[] args) {
		try {
			TransportServiceHTTPSStub stub = new TransportServiceHTTPSStub("http://localhost:8088/mockOpTransportServiceEndpoint0Binding");
			CreateTransportRequestDocument createReq = CreateTransportRequestDocument.Factory.newInstance();
			CreateTransportRequest cReq = CreateTransportRequest.Factory.newInstance();
			ApplicationHeader header = ApplicationHeader.Factory.newInstance();
			header.setRequestedDate("2016-10-24T20:12:34");
			header.setRequestedSystem("School App");
			header.setRetryLimit("6");
			
			School school = School.Factory.newInstance();
			school.setAddress("school address");
			school.setName("school name");
			school.setId("schoolId");
			
			Transport transport = Transport.Factory.newInstance();
			Driver driver = Driver.Factory.newInstance();
			driver.setMinimumAge(40);
			driver.setMinimumExp(5);
			
			transport.setDriver(driver);
			transport.setContract(12);
			transport.setRentalStartDate(Calendar.getInstance());
			transport.setSeats(20);
			transport.setType("Mini Van");
			DataHeader dHeader = DataHeader.Factory.newInstance();
			dHeader.setSchool(school);
			dHeader.setTransport(transport);
			
			cReq.setApplicationHeader(header);
			cReq.setDataHeader(dHeader);
			
			createReq.setCreateTransportRequest(cReq);
			
			CreateTransportResponseDocument respDoc= stub.opCreateTransportService(createReq);
			CreateTransportResponse response = respDoc.getCreateTransportResponse();
			System.out.println(response.getAckMessage().getMessageDescription());
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
