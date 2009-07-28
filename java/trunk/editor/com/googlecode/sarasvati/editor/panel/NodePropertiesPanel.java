/*
    This file is part of Sarasvati.

    Sarasvati is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as
    published by the Free Software Foundation, either version 3 of the
    License, or (at your option) any later version.

    Sarasvati is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with Sarasvati.  If not, see <http://www.gnu.org/licenses/>.

    Copyright 2008 Paul Lorenz
*/
package com.googlecode.sarasvati.editor.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.googlecode.sarasvati.JoinType;
import com.googlecode.sarasvati.editor.command.CommandStack;
import com.googlecode.sarasvati.editor.model.EditorNode;
import com.googlecode.sarasvati.editor.model.EditorNodeType;
import com.googlecode.sarasvati.editor.model.EditorNodeTypeAttribute;
import com.googlecode.sarasvati.editor.model.EditorPreferences;
import com.googlecode.sarasvati.editor.model.NodeState;
import com.googlecode.sarasvati.util.SvUtil;
import com.googlecode.sarasvati.visual.common.NodeDrawConfig;
import com.googlecode.sarasvati.visual.icon.NodeIconType;

/**
 *
 * @author paul
 */
public class NodePropertiesPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    /** Creates new form NodePropertiesPanel */
    public NodePropertiesPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nodeNameLabel = new javax.swing.JLabel();
        nodeNameInput = new javax.swing.JTextField();
        startNodeInput = new javax.swing.JCheckBox();
        typeLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        customPropertiesInput = new javax.swing.JTable();
        customPropertiesLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        addPropertyButton = new javax.swing.JButton();
        deletePropertyButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        guardInput = new javax.swing.JTextArea();
        guardLabel = new javax.swing.JLabel();
        joinTypeLabel = new javax.swing.JLabel();
        joinTypeInput = new javax.swing.JComboBox();
        joinParamLabel = new javax.swing.JLabel();
        joinParamInput = new javax.swing.JTextField();
        nodeTypeInput = new javax.swing.JComboBox();
        joinTypeDescriptionLabel = new javax.swing.JLabel();

        setForeground(new java.awt.Color(53, 53, 53));
        setMinimumSize(new java.awt.Dimension(200, 100));

        nodeNameLabel.setLabelFor(nodeNameInput);
        nodeNameLabel.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.nodeNameLabel.text")); // NOI18N

        nodeNameInput.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.nodeNameInput.text")); // NOI18N

        startNodeInput.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.startNodeInput.text")); // NOI18N
        startNodeInput.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        typeLabel.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.typeLabel.text")); // NOI18N

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        customPropertiesInput.setModel(getCustomNodeProperties());
        customPropertiesInput.setFillsViewportHeight(true);
        customPropertiesInput.setMinimumSize(new java.awt.Dimension(10, 10));
        customPropertiesInput.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(customPropertiesInput);
        customPropertiesInput.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.customPropertiesInput.columnModel.title0")); // NOI18N
        customPropertiesInput.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.customPropertiesInput.columnModel.title1")); // NOI18N

        customPropertiesLabel.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.customPropertiesLabel.text")); // NOI18N

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        cancelButton.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.cancelButton.text")); // NOI18N
        cancelButton.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel1.add(cancelButton);

        applyButton.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.applyButton.text")); // NOI18N
        applyButton.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel1.add(applyButton);

        addPropertyButton.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.addPropertyButton.text")); // NOI18N

        deletePropertyButton.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.deletePropertyButton.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deletePropertyButton)
                    .addComponent(addPropertyButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addPropertyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(deletePropertyButton)
                .addContainerGap())
        );

        guardInput.setColumns(20);
        guardInput.setRows(5);
        jScrollPane2.setViewportView(guardInput);

        guardLabel.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.guardLabel.text")); // NOI18N

        joinTypeLabel.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.joinTypeLabel.text")); // NOI18N

        joinTypeInput.setModel(new DefaultComboBoxModel( JoinType.values() ));

        joinParamLabel.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.joinParamLabel.text")); // NOI18N

        joinParamInput.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.joinParamInput.text")); // NOI18N

        nodeTypeInput.setModel(getNodeTypesModel());

        joinTypeDescriptionLabel.setForeground(new java.awt.Color(102, 102, 102));
        joinTypeDescriptionLabel.setText(org.openide.util.NbBundle.getMessage(NodePropertiesPanel.class, "NodePropertiesPanel.joinTypeDescriptionLabel.text")); // NOI18N
        joinTypeDescriptionLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        joinTypeDescriptionLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guardLabel)
                    .addComponent(joinParamLabel)
                    .addComponent(joinTypeLabel)
                    .addComponent(typeLabel)
                    .addComponent(nodeNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addComponent(joinParamInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addComponent(nodeNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nodeTypeInput, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joinTypeInput, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(joinTypeDescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(customPropertiesLabel)
                .addContainerGap(311, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(startNodeInput)
                .addContainerGap(576, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nodeNameLabel)
                    .addComponent(nodeNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeLabel)
                            .addComponent(nodeTypeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(joinTypeLabel)
                            .addComponent(joinTypeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(joinTypeDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joinParamLabel)
                    .addComponent(joinParamInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guardLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(startNodeInput)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(customPropertiesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPropertyButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable customPropertiesInput;
    private javax.swing.JLabel customPropertiesLabel;
    private javax.swing.JButton deletePropertyButton;
    private javax.swing.JTextArea guardInput;
    private javax.swing.JLabel guardLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField joinParamInput;
    private javax.swing.JLabel joinParamLabel;
    private javax.swing.JLabel joinTypeDescriptionLabel;
    private javax.swing.JComboBox joinTypeInput;
    private javax.swing.JLabel joinTypeLabel;
    private javax.swing.JTextField nodeNameInput;
    private javax.swing.JLabel nodeNameLabel;
    private javax.swing.JComboBox nodeTypeInput;
    private javax.swing.JCheckBox startNodeInput;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables

    public ComboBoxModel getNodeTypesModel ()
    {
      return new DefaultComboBoxModel( EditorPreferences.getInstance().getNodeTypes().toArray() );
    }

    public ComboBoxModel getJoinTypesModel ()
    {
      return new DefaultComboBoxModel( JoinType.values() );
    }

    public TableModel getCustomNodeProperties ()
    {
      return tableModel;
    }

    private final DefaultTableModel tableModel = new DefaultTableModel( new String[] { "Name", "Value" }, 0 );

    public void setup (final JDialog dialog,
                       final EditorNode node)
    {
      customPropertiesInput.putClientProperty( "terminateEditOnFocusLost", Boolean.TRUE );

      cancelButton.addActionListener( new ActionListener()
      {
        @Override
        public void actionPerformed (ActionEvent e)
        {
          dialog.setVisible( false );
        }
      });

      applyButton.addActionListener( new ActionListener()
      {
        @Override
        public void actionPerformed (final ActionEvent e)
        {
          Map<String,String> customProperties = new LinkedHashMap<String,String> ();

          for ( int row = 0; row < tableModel.getRowCount(); row++ )
          {
            customProperties.put( (String)tableModel.getValueAt( row, 0 ), (String)tableModel.getValueAt( row, 1 ) );
          }

          NodeState newState =
            new NodeState( nodeNameInput.getText(),
                           ((EditorNodeType)nodeTypeInput.getSelectedItem()).getName(),
                           (JoinType)joinTypeInput.getSelectedItem(),
                           SvUtil.nullIfBlank( joinParamInput.getText() ),
                           startNodeInput.isSelected(),
                           SvUtil.nullIfBlank( guardInput.getText() ),
                           customProperties );

          if ( !newState.equals( node.getState() ) )
          {
            CommandStack.editGraphMember( node, newState );
          }

          dialog.setVisible( false );
        }
      });

      nodeTypeInput.addActionListener( new ActionListener()
      {
        @Override
        public void actionPerformed (ActionEvent e)
        {
          nodeTypeChanged( node );
        }
      });

      joinTypeInput.addActionListener( new ActionListener()
      {
        @Override
        public void actionPerformed (ActionEvent e)
        {
          JoinType joinType = (JoinType)joinTypeInput.getSelectedItem();
          joinTypeDescriptionLabel.setText( "<html>" + joinType.getDescription() + "</html>" );
        }
      });

      NodeState state = node.getState();
      nodeNameInput.setText( state.getName() );
      nodeTypeInput.setSelectedItem( state.getEditorNodeType() );
      joinTypeInput.setSelectedItem( state.getJoinType() );
      joinParamInput.setText( SvUtil.nullIfBlank( state.getJoinParam() ) );
      guardInput.setText( SvUtil.nullIfBlank( state.getGuard() ) );
      startNodeInput.setSelected( state.isStart() );

      addPropertyButton.addActionListener( new ActionListener()
      {
        @Override
        public void actionPerformed (ActionEvent e)
        {
          tableModel.addRow( new String[] { "", "" } );
        }
      });

      deletePropertyButton.addActionListener( new ActionListener()
      {
        @Override
        public void actionPerformed (ActionEvent e)
        {
          int [] indices = customPropertiesInput.getSelectedRows();
          Arrays.sort( indices );
          for ( int i = indices.length - 1; i >= 0; i-- )
          {
            tableModel.removeRow( indices[i] );
          }
        }
      });
    }

    public void nodeTypeChanged (final EditorNode node)
    {
      EditorNodeType nodeType = (EditorNodeType)nodeTypeInput.getSelectedItem();

      if ( nodeType == null )
      {
        nodeType = new EditorNodeType( "node", false, NodeIconType.Oval, NodeDrawConfig.NODE_BG_ACTIVE );
      }

      addPropertyButton.setEnabled( nodeType.isAllowNonSpecifiedAttributes() );
      deletePropertyButton.setEnabled( nodeType.isAllowNonSpecifiedAttributes() );

      Map<String, String> props = new LinkedHashMap<String, String>();

      for ( EditorNodeTypeAttribute attr : nodeType.getAttributes() )
      {
        props.put( attr.getName(), attr.getDefaultValue() );
      }

      NodeState state = node.getState();
      if ( state.getCustomProperties() != null )
      {
        for ( Map.Entry<String,String> entry : state.getCustomProperties().entrySet() )
        {
          if ( nodeType.isAllowNonSpecifiedAttributes() || props.containsKey( entry.getKey() ) )
          {
            props.put( entry.getKey(), entry.getValue() );
          }
        }
      }

      while ( tableModel.getRowCount() > 0 )
      {
        tableModel.removeRow( tableModel.getRowCount() - 1 );
      }

      for ( Map.Entry<String,String> entry : props.entrySet() )
      {
        tableModel.addRow( new String[] { entry.getKey(), entry.getValue() } );
      }
    }
}
