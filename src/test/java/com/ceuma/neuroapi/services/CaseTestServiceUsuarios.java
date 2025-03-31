package com.ceuma.neuroapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.springframework.boot.test.context.SpringBootTest;

import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoIn;
import com.ceuma.neuroapi.application.services.UsuarioService;
import com.ceuma.neuroapi.utils.enums.TipoUsuario;

@SpringBootTest
public class CaseTestServiceUsuarios {

    @InjectMocks
    UsuarioService service2;

    @Test
    void CaseOfCreateAnUserTypeMedico(){
        // instancias de usuarios
        UsuarioDtoIn testUser1 = new UsuarioDtoIn("vitor@gmail.com","vitorpsw","vitor",TipoUsuario.MEDICO);
        UsuarioDtoIn testUser2 = new UsuarioDtoIn("charles@yahoo.com","charlespsw","charles",TipoUsuario.MEDICO);
        UsuarioDtoIn testUser3 = new UsuarioDtoIn("marx@hotmail.com","marxpsw","marx",TipoUsuario.MEDICO);



        // testes
        assertEquals("UsuarioDto [email=vitor@gmail.com, nome=vitor, tipo=MEDICO]",service2.createAnUser(testUser1).toString());
        assertEquals("UsuarioDto [email=charles@yahoo.com, nome=charles, tipo=MEDICO]",service2.createAnUser(testUser2).toString());
        assertEquals("UsuarioDto [email=marx@hotmail.com, nome=marx, tipo=MEDICO]",service2.createAnUser(testUser3).toString());
    }

    // testando erros de campos nulos
    @Test
    void CaseOfCreateAnUserWithFieldNull(){
        
        UsuarioDtoIn testUser1 = new UsuarioDtoIn("","saz","saturn",TipoUsuario.MEDICO);
        UsuarioDtoIn testUser2 = new UsuarioDtoIn(null,"gakpo@gmail.com","saturn",TipoUsuario.MEDICO);
        UsuarioDtoIn testUser3 = new UsuarioDtoIn(null,"jarvis@gmail.com","martispsw",TipoUsuario.MEDICO);


        Error error1 = assertThrows(Error.class,() -> service2.createAnUser(testUser1));
        Error error2 = assertThrows(Error.class,() -> service2.createAnUser(testUser2));
        Error error3 = assertThrows(Error.class,() -> service2.createAnUser(testUser3));

        assertEquals("campos nulos",error1.getMessage());
        assertEquals("campos nulos",error2.getMessage());
        assertEquals("campos nulos",error3.getMessage());
    }

    //teste de campos vazios
    @Test
    void CaseOfCreateAnUserWithFieldsBlanck(){
        
        UsuarioDtoIn testUser1 = new UsuarioDtoIn("","saz","saturn",TipoUsuario.MEDICO);
        UsuarioDtoIn testUser2 = new UsuarioDtoIn("gakpo@gmail.com","","saturn",TipoUsuario.MEDICO);
        UsuarioDtoIn testUser3 = new UsuarioDtoIn("jarvis@gmail.com","martispsw","",TipoUsuario.MEDICO);


        Error error1 = assertThrows(Error.class,() -> service2.createAnUser(testUser1));
        Error error2 = assertThrows(Error.class,() -> service2.createAnUser(testUser2));
        Error error3 = assertThrows(Error.class,() -> service2.createAnUser(testUser3));

        assertEquals("campos vazios",error1.getMessage());
        assertEquals("campos vazios",error2.getMessage());
        assertEquals("campos vazios",error3.getMessage());
    }

    @Test
    void CaseOfCreateAnUserWithPatternEmailIncorrect(){
        
        UsuarioDtoIn testUser1 = new UsuarioDtoIn("gakpo","saz","saturn",TipoUsuario.MEDICO);
        UsuarioDtoIn testUser2 = new UsuarioDtoIn("gakpo.com","sza","saturn",TipoUsuario.MEDICO);
        UsuarioDtoIn testUser3 = new UsuarioDtoIn("jarvis@gmail","martispsw","sz",TipoUsuario.MEDICO);



        Error error1 = assertThrows(Error.class,() -> service2.createAnUser(testUser1));
        Error error2 = assertThrows(Error.class,() -> service2.createAnUser(testUser2));
        Error error3 = assertThrows(Error.class,() -> service2.createAnUser(testUser3));

        assertEquals("formato de email esta errado",error1.getMessage());
        assertEquals("formato de email esta errado",error2.getMessage());
        assertEquals("formato de email esta errado",error3.getMessage());
    }

    
    
    
}
