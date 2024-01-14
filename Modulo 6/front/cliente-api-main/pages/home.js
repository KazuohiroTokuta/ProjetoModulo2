import 'bootstrap/dist/css/bootstrap.min.css';
import { useEffect, useState } from "react";
import axios from "axios";
import style from '../styles/Home.module.css'
import Link from 'next/link'; //importe links para criar links de navegacao

const Home = () => {
  const [passageiros, setPassageiros] = useState([]);

  useEffect(() => {
    // Faça uma chamada GET para a API Spring Boot
    axios
      .get("https://localhost:7162/api/Passageiros")
      .then((response) => {
        setPassageiros(response.data);
      })
      .catch((error) => {
        console.error("Erro ao buscar a lista de Categorias:", error);
      });
  }, []);

  return (
    <div>

      <h1 className={style.h1}>Teste</h1>
      <table className="table container tabela">
        <thead>
          <tr>
            <th>CPF</th>
            <th>Nome</th>
            <th>passaporte</th>
            <th>Email</th>
            <th>telefone</th>
          </tr>
        </thead>
        
          {passageiros.map((element) => (
            <tbody key={element.categoriaCPF}>
            <tr className={style.tabela}>
              <td>{element.CPF}</td>
              <td>{element.nome_passageiro}</td>
              <td>{element.passaporte}</td>
              <td>{element.email}</td>
              <td>{element.telefone}</td>
              <td>
                <Link href={'/update-client/${element.CPF}'} className="btn btn-warning">Editar</Link>
                <Link href={'/delete-client/${element.CPF}'} className="btn btn btn-warning">Excluir</Link>
              </td>
              </tr>
              </tbody>
          ))}
        
      </table>
    </div>
  );
};

export default Home;
