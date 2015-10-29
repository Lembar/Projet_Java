package dao;

import java.util.ArrayList;

import model.metier.Cotisation;

public interface CotisationDAO extends Dao<Cotisation> {

	ArrayList<Cotisation> findAll();
}