package br.com.vs1.imobiliaria.web.services;

/*
 * Copyright (c)  @vsantos1 - https://github.com/vsantos1
 * 2022-2023.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import br.com.vs1.imobiliaria.web.dtos.ImovelDTO;
import br.com.vs1.imobiliaria.web.utils.Randomizar;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class WebArquivoUploadService {


    private final String UPLOAD_DIR = "C://uploads";
    

    public WebArquivoUploadService() {
    }


    /**
     * @param part Part
     */
    protected String execute(MultipartFile part) throws IOException {

        StringBuilder fileNames = new StringBuilder();

        Path fileNameAndPath = Paths.get(UPLOAD_DIR, fileNames.append(UUID.randomUUID()).append("_").append(part.getOriginalFilename()).toString());

        Files.write(fileNameAndPath, part.getBytes());

        return fileNameAndPath.toString();
    }

    /**
     * @param part        Part
     * @param maxFileSize int (MB)
     * @throws IOException IOException
     */
    protected void isSizeAllowed(MultipartFile part, int maxFileSize) throws IOException {

        // 1MB
        int DEFAULT_FILE_SIZE = 1024 * 1024;

        maxFileSize = DEFAULT_FILE_SIZE * maxFileSize;


        if (part.getSize() > maxFileSize) {
            throw new IOException("File size is too large");
        }
    }


    public String upload(ImovelDTO imovelDTO, int maxFileSize) throws IOException {
        StringBuilder sb = new StringBuilder();
        String fileName = sb.append(Randomizar.nomeAleatorio(10)).append("_").append(imovelDTO.getFile().getOriginalFilename()).toString();

        this.isSizeAllowed(imovelDTO.getFile(), maxFileSize);
        if (!imovelDTO.getFile().isEmpty() || imovelDTO.getFile() != null) {

            try {
                Path currentPath = Paths.get(".");
                Path absolutePath = currentPath.toAbsolutePath();
                imovelDTO.setFoto(absolutePath + "/src/main/resources/static/image/" + fileName);
                Path path = Paths.get(imovelDTO.getFoto());
                Files.write(path, imovelDTO.getFile().getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return fileName;

    }

 

}
