package com.agenciadeviagens.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agenciadeviagens.model.Cliente;

public class ClienteDAO {
	
	
	private static String sql;
	private final Connection connection;
	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}
	
	//CREATE
	public void createCliente(Cliente cliente) {
		sql = "INSERT INTO cliente (nome, sobrenome, endereco, email, telefone) VALUES (?,?,?,?,?)";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSobrenome());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getTelefone());
			
			stmt.executeUpdate();
			System.out.println("Cliente criado com sucesso: " + cliente.getNome() + " com email: " + cliente.getEmail());
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//READ
	public Cliente readCliente(int ID) {
	    sql = "SELECT * FROM cliente WHERE IDCliente = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setInt(1, ID);
	        try (ResultSet resultSet = stmt.executeQuery()) {
	            if (resultSet.next()) {
	                String nome = resultSet.getString("nome");
	                String sobrenome = resultSet.getString("sobrenome");
	                String endereco = resultSet.getString("endereco");
	                String email = resultSet.getString("email");
	                String telefone = resultSet.getString("telefone");
	                return new Cliente(nome, sobrenome, endereco, email, telefone);
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return null;
	}
	
	//UPDATE
	public void updateCliente(Cliente cliente) {
	    sql = "UPDATE cliente SET nome = ?, sobrenome = ?, endereco = ?, email = ?, telefone = ? WHERE IDCliente = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, cliente.getNome());
	        stmt.setString(2, cliente.getSobrenome());
	        stmt.setString(3, cliente.getEndereco());
	        stmt.setString(4, cliente.getEmail());
	        stmt.setString(5, cliente.getTelefone());
	        stmt.setInt(6, cliente.getID());
	        stmt.executeUpdate();
	        System.out.println("Cliente atualizado com sucesso: " + cliente.getNome() + " com email: " + cliente.getEmail());
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	
	//DELETE
	public void deleteCliente(int ID) {
	    sql = "DELETE FROM cliente WHERE IDCliente = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setInt(1, ID);
	        stmt.executeUpdate();
	        System.out.println("Cliente com ID " + ID + " deletado com sucesso.");
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}


	

}
