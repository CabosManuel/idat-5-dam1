package idat.edu.pe.appec2manuelcabos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import idat.edu.pe.appec2manuelcabos.adapter.LibroAdapter;
import idat.edu.pe.appec2manuelcabos.model.Libro;

public class ListadoActivity extends AppCompatActivity {

    private RecyclerView rvDatos;
    private LibroAdapter libroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        rvDatos = findViewById(R.id.rvdatos);
        rvDatos.setLayoutManager(new LinearLayoutManager(ListadoActivity.this));
        libroAdapter = new LibroAdapter(ListadoActivity.this);
        rvDatos.setAdapter(libroAdapter);

        ArrayList<Libro> lista = new ArrayList<>();
        lista.add(new Libro(
                lista.size() + 1,
                R.drawable.genetica_clinica,
                2019,
                "Genética clínica (2a. ed.)",
                "La calidad de sus autores hizo que Genética clínica, desde su primera edición, se posicionara como un referente para los estudiantes de medicina, como para los residentes de genética. Es por ello, que ahora, en su segunda edición, además de abordar temas clásicos como Errores innatos del metabolismo, Herencia mendeleliana, Enfermedades mitocondriales o Herencia multifactorial; se incluyen nuevos temas como Genética y evolución, Genética de poblaciones o el asombroso Sistema de edición génica CRISPR-Cas9."
        ));
        lista.add(new Libro(
                lista.size() + 1,
                R.drawable.trauma_estado,
                2019,
                "Trauma y estado de choque",
                "Los interesados tendrán acceso a información relacionada con la evaluación y el manejo inicial del enfermo politraumatizado, el diagnóstico y el abordaje del estado de choque, las nuevas propuestas relacionadas con la hemorragia y la coagulopatía en trauma, el uso racional de sangre, hemocomponentes y concentrados de factores de coagulación, el manejo de la vía aérea y abordajes novedosos y vanguardistas, como son lo relacionado con el equilibrio ácido–base y la implementación de diferentes protocolos de insonación, que se han posicionado como herramientas fundamentales en la evaluación del paciente politraumatizado y/o en estado de choque. Cada uno de los capítulos está escrito con gran elegancia, son de fácil lectura y están ilustrados con tablas, figuras, algoritmos e imágenes."
        ));
        lista.add(new Libro(
                lista.size() + 1,
                R.drawable.manual_patologia_vocal,
                2019,
                "Manual de patología vocal ",
                "En patología vocal, el escenario ideal es la colaboración entre médico foniatra, logopeda y cirujano ORL. Para el terapeuta de la voz que, lógicamente, carece de formación específicamente médica, este manual quiere abordar los trastornos vocales desde la perspectiva foniátrica, a caballo entre la otorrinolaringología y la rehabilitación, con especial énfasis en los aspectos más relevantes para el logopeda, numerosas imágenes estroboscópicas y orientaciones para el tratamiento, sirviendo así de puente entre la medicina y la logopedia para todos los profesionales de la voz."
        ));
        lista.add(new Libro(
                lista.size() + 1,
                R.drawable.experiencia_dolor,
                2011,
                "La experiencia del dolor ",
                "El texto que presentamos tiene como intención fundamental divulgar de forma sencilla, pero rigurosa, los rasgos mas importantes de lo que implica la experiencia dolorosa. Nos importa especialmente establecer una serie de tratamientos psicológicos que se han comprobado como muy útiles en personas que sufren dolor crónico. El último capítulo intenta ser una Vía de esperanza para aquellas personas que padecen dolor, demostrando que el dolor puede ser también creativo y que hay personas cuya Vida social y profesional es satisfactoria aún padeciendo dolor físico."
        ));
        lista.add(new Libro(
                lista.size() + 1,
                R.drawable.medicina_dolor_bolsillo,
                2011,
                "Medicina del dolor de bolsillo ",
                "Medicina del dolor de bolsillo es un recurso extraordinario para que residentes y médicos comprendan las bases del dolor agudo y crónico, e incluye todas las directrices clínicas y estándares para el cuidado de los pacientes. Se trata de una obra concisa, actualizada y basada en la evidencia, que se presenta en el formato de la ya popular colección de bolsillo, idónea para adaptarse al ritmo de los entornos de cuidado sanitario. ConÂ Medicina del dolor de bolsilloÂ se pretende satisfacer a los médicos de todo el mundo de cualquier especialidad, de la práctica tanto académica como privada."
        ));
        lista.add(new Libro(
                lista.size() + 1,
                R.drawable.sindrome_sotos,
                2009,
                "Síndrome de Sotos",
                "A lo largo del presente trabajo se va a describir y profundizar en el SS. En primer lugar es conveniente definir qué se entiende por Síndrome: “La palabra síndrome simplemente quiere decir que un número de características físicas y/o evolutivas ocurren juntas. La ventaja de tener un síndrome específico es que permite aprender como otras personas con el mismo síndrome han progresado, que retos han afrontado y quizá que tipo de intervenciones son de mayor ayuda. Al igual que niños en una misma familia tienen diferentes habilidades y necesidades, también ocurre lo mismo con niños que tienen el mismo diagnóstico, como es el caso de los niños de SS."
        ));
        lista.add(new Libro(
                lista.size() + 1,
                R.drawable.historia_enfermedades_infecciosas,
                2010,
                "Historia de las enfermedades infecciosas",
                "A lo largo de su historia, las enfermedades infecciosas han ocasionado infinitas muertes y muy graves quebrantos para la humanidad. Y aún hoy, tres de ellas: el sida, la tuberculosis y el paludismo son una temible causa de muerte en los países del tercer mundo. Desde la antigüedad ha sido posible seguir el relato de terribles plagas que por sus características se identificaron sin gran dificultad con determinadas enfermedades infecciosas, y para las que incluso algunos, ya en tiempos remotos, llegaron a intuir la existencia de imperceptibles partículas de condición incierta como explicación para su transmisión, que Fracastoro en el siglo XVI definió como minúsculos seminaria."
        ));
        lista.add(new Libro(
                lista.size() + 1,
                R.drawable.placenta_fisiologia_patologia,
                1992,
                "La placenta: fisiología y patología ",
                "La decidua como placenta materna. Introducción a la patología de la placenta.Insuficiencia placentaria. Formas clínicas de la insuficiencia placentaria. Morfología de la placenta en el aborto espontáneo. Anomalías en la forma y en lainserción placentaria. Placenta previa. La enfermedad trofoblástica. Tumorestrofoblásticos malignos. Abruptio placentae.INDICE: Generalidades sobre la placenta. La placenta en los mamíferos. Primeras fases del desarrollo embrionario: Diferenciación del trofoblasto y del embrioblasto. La circulación placentaria. La placenta como filtro. El hígado transitorio: La placenta como órgano metabólico y de depósito. La placenta como órgano esteroidogénico. Las proteínas placentarias. Hormonales y no hormonales.La placenta y la inmunotolerancia a la gestación."
        ));
        lista.add(new Libro(
                lista.size() + 1,
                R.drawable.ovario_fisiologia_patologia,
                1995,
                "El ovario: fisiología y patología \n",
                "El ovario en los vertebrados. Desarrollo del ovario. Biosíntesis de las hormonas sexuales. Hormonas ováricasno esteroideas.. Las gonadotropinas y otras hormonas que actúan sobre el ovario. Factores de crecimiento del ovario. El ciclo ovárico.Los mecanismos de la ovulación. El ovario y la gestación. Elovario en la pubertad y en la menopausia. Los ovarios de las disgenesias gonadales. Alteraciones funcionales del ciclo.. El ovario poliquístico. Tumores ováricos. Tumores del sacovitelino. Tumores epiteliales comunes de ovario. Tumores ováricos: Tumores de los cordones sexuales. Los tumores funcionantes del ovario, etc."
        ));
        lista.add(new Libro(
                lista.size() + 1,
                R.drawable.nino_criticamente_enfermo,
                1996,
                "Niño críticamente enfermo",
                "El presente libro reúne los 27 capítulos más actuales e interesantes de los cuidados intensivos pediátricos; aborda en profundidad los avances en las patologías de los niños críticamente enfermos y los modernos sistemas de monitorización; pone al día las técnicas, métodos diagnósticos y terapéuticos de las situaciones críticas para la vida de los neonatos, lactantes y niños. El libro incluye un disquete que explica de manera gráfica y dinámica de la ventilación mecánica y su monitorización , haciendo fácil y agradable uno de los aspectos más complicados del manejo de los pacientes graves."
        ));

        libroAdapter.agregarElementos(lista);
    }
}